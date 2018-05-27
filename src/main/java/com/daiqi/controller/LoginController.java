package com.daiqi.controller;

import com.daiqi.entity.User;
import com.daiqi.entity.UserRole;
import com.daiqi.extend.ApplicationProjectExtends;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.service.*;
import com.daiqi.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.*;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {


    @Resource
    private UserService userService;

    @Resource
    private CertificationUserService certificationUserService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private ProjectService projectService;

    @Resource
    private ApplicationProjectService applicationProjectService;

    @Resource
    private MessageService messageService;

    @Resource
    private FeedbackService feedbackService;

    @RequestMapping(value = "login")
    public ModelAndView login1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "login.do")
    public String login(User user,boolean remember,
                        HttpServletRequest request, HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getEmail(), CryptographyUtil.md5(user.getPassword(),"daiqi"));
        try {
            subject.login(token);
            if(remember) {
                Cookie cookie = new Cookie("admin", user.getEmail() + "-" + user.getPassword());
                cookie.setMaxAge(30 * 24 * 60 * 60);
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }else{
                Cookie cookie = new Cookie("admin", null);
                cookie.setMaxAge(0);
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            //是否有反馈信息未处理
            Integer feedbackBage = 0;
            feedbackBage = feedbackService.countByResult();
            //是否有新注册用户，以及新认证用户
            Integer userBage = 0 , cuserBage = 0;
            userBage = userService.countByRegistertime(new Date());
            cuserBage = certificationUserService.countByCertificationtime(new Date());
            //是否发布了新的项目
            Integer projectBage = 0;
            projectBage = projectService.countByReleasetime(new Date());

            request.getSession().setAttribute("feedbackBage",feedbackBage);
            request.getSession().setAttribute("userBage",userBage);
            request.getSession().setAttribute("cuserBage",cuserBage);
            request.getSession().setAttribute("projectBage",projectBage);

            return "redirect:admin/menu.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error","信息错误！");
            return "login";
        }
    }

    @RequestMapping(value = "logout.do")
    public String logout(HttpSession session){
        SecurityUtils.getSubject().logout();
        return "redirect:login.jsp";
    }

    @RequestMapping(value = "loginIndex.do")
    public ModelAndView loginIndex(User user, boolean remember,
                                   HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getEmail(), CryptographyUtil.md5(user.getPassword(),"daiqi"));
        try {
            subject.login(token);
            //想要实现一下保存密码功能，先试试吧
            if(remember){
                Cookie cookie = new Cookie("user",user.getEmail()+"-"+user.getPassword());
                cookie.setMaxAge(30*24*60*60);
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }else {
                Cookie cookie = new Cookie("user", null);
                cookie.setMaxAge(0);
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            //---------------------------------------
            //再实现一下新消息提醒功能吧，真的是烦，还不如买一个毕业设计，简直要折麽死人了
            //是否有人申请项目
            Integer RprojectInfoBadge = 0;
            user = (User) session.getAttribute("user");
            List<ProjectExtends> projectExtendsList = projectService.findExtendsByReleaser(user.getUserid());
            for(ProjectExtends projectExtends : projectExtendsList){
                List<ApplicationProjectExtends> applicationProjectExtendsList = applicationProjectService.findExtendsByProjectid(projectExtends.getProjectid());
                for(ApplicationProjectExtends applicationProjectExtends : applicationProjectExtendsList){
                    if(applicationProjectExtends.getResult().equals("审核中")){
                        RprojectInfoBadge = 1;
                        break;
                    }
                }
            }
            //是否有私信未读
            Integer ReceiveMessageBage = 0;
            ReceiveMessageBage = messageService.countByReceiver(user.getUserid());

            session.setAttribute("RprojectInfoBadge",RprojectInfoBadge);
            session.setAttribute("ReceiveMessageBage",ReceiveMessageBage);
            //modelAndView.addObject("badge",badge);

            //---------------------------------------
            modelAndView.setViewName("index");
        }catch (Exception e){
            e.printStackTrace();
            modelAndView.addObject("message","用户名或密码错误！");
            modelAndView.setViewName("tip");
        }
        return modelAndView;
    }

    @RequestMapping(value = "logoutIndex.do")
    public String logoutIndex(HttpSession session){
        SecurityUtils.getSubject().logout();
        return "redirect:index.jsp";
    }

    @RequestMapping(value = "registerIndex.do")
    public ModelAndView registerIndex(User user){
        //TODO:如果有时间，以后要在这里做邮箱验证，不过现在就先模拟一下完成功能流程
        ModelAndView modelAndView = new ModelAndView();
        user.setPassword(CryptographyUtil.md5(user.getPassword(),"daiqi"));
        user.setUserimage("cps/images/userImages/default.jpg");
        user.setRegistertime(new Date());
        user.setStatus("正常");

        Integer result = null;
        try {
            result = userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("message","邮箱账号已存在！");
            modelAndView.setViewName("tip");
            return modelAndView;
        }
        if(result>0){
            UserRole userRole = new UserRole();
            userRole.setUserid(user.getUserid());
            userRole.setRoleid(2);
            try {
                result = userRoleService.saveUserRole(userRole);
            } catch (Exception e) {
                e.printStackTrace();
                modelAndView.addObject("message","角色分配异常，请登录后反馈管理员！");
                modelAndView.setViewName("tip");
                return modelAndView;
            }
            if(result>0){
                modelAndView.addObject("message","注册成功！");
            }else {
                modelAndView.addObject("message","注册失败！");
            }
        }else {
            modelAndView.addObject("message","注册失败！");
        }
        modelAndView.setViewName("tip");
        return modelAndView;
    }

    @RequestMapping(value = "resetPassword")
    public ModelAndView resetPassword(String email){
        ModelAndView modelAndView = new ModelAndView();
        User user = null;
        try {
            user = userService.findByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("message","数据库异常，请稍后再试！");
            modelAndView.setViewName("tip");
            return modelAndView;
        }
        if(user!=null){
            user.setPassword(CryptographyUtil.md5("123456","daiqi"));
            Integer total = null;
            try {
                total = userService.updateUser(user);
            } catch (Exception e) {
                e.printStackTrace();
                modelAndView.addObject("message","数据库异常，请稍后再试！");
                modelAndView.setViewName("tip");
                return modelAndView;
            }
            if(total>0){
                modelAndView.addObject("message","您的密码已重置（123456）！");
            }else {
                modelAndView.addObject("message","密码找回失败！");
            }

        }else {
            modelAndView.addObject("message","您的账号不存在！");
        }
        modelAndView.setViewName("tip");
        return modelAndView;
    }
}
