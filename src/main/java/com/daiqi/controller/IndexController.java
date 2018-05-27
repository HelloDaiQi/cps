package com.daiqi.controller;

import com.daiqi.entity.*;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.extend.ProjectMumberExtends;
import com.daiqi.extend.UserExtends;
import com.daiqi.service.*;
import com.daiqi.vo.IndexProjectSearchData;
import com.daiqi.vo.IndexUserSearchData;
import com.daiqi.vo.PageData;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping(value = "index")
public class IndexController {

    @Resource
    private UserService userService;

    @Resource
    private ProjectService projectService;

    @Resource
    private SchoolService schoolService;

    @Resource
    private SkillService skillService;

    @Resource
    private ProjectTypeService projectTypeService;

    @Resource
    private FocusService focusService;

    @Resource
    private ApplicationProjectService applicationProjectService;

    @Resource
    private ProjectMumberService projectMumberService;

    @RequestMapping(value = "index.do")
    public ModelAndView index(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        ServletContext application = request.getServletContext();
        List<UserExtends> userExtendsList = userService.findNew();
        List<ProjectExtends> projectExtendsList = projectService.findNew();
        application.setAttribute("userExtendsList",userExtendsList);
        application.setAttribute("projectExtendsList",projectExtendsList);
        modelAndView.setViewName("index");
        return modelAndView;
    }

//用户信息
    @RequestMapping(value = "userList.do")
    public ModelAndView userList(IndexUserSearchData indexUserSearchData) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        PageData pageData = new PageData();
        PageInfo page = userService.findExtendsByPage(indexUserSearchData);
        List<UserExtends> userExtendsList = page.getList();
        pageData.setPageNum(page.getPageNum());
        pageData.setPages(page.getPages());
        pageData.setIsFirstPage(page.isIsFirstPage());
        pageData.setIsLastPage(page.isIsLastPage());
        List<School> schoolList = schoolService.findAll();
        List<Skill> skillList = skillService.findAll();
        modelAndView.addObject("userExtendsList",userExtendsList);
        modelAndView.addObject("pageData",pageData);
        modelAndView.addObject("schoolList",schoolList);
        modelAndView.addObject("skillList",skillList);
        modelAndView.addObject("iusd",indexUserSearchData);
        modelAndView.setViewName("userList");
        return modelAndView;
    }

    @RequestMapping(value = "showUser.do")
    public ModelAndView showUser(Integer userid,HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        Boolean isFocus = false;
        if(user!=null){
            isFocus = focusService.isFocused(user.getUserid(),userid);
        }
        UserExtends userExtends = userService.findExtendsByUserid(userid);
        //发布项目数以及参加项目数
        Integer releaseNumber = projectService.countReleaseNumber(userid);
        Integer joinNumber = projectMumberService.countJoinNumber(userid);
        modelAndView.addObject("userExtends",userExtends);
        modelAndView.addObject("isFocus",isFocus);
        modelAndView.addObject("releaseNumber",releaseNumber);
        modelAndView.addObject("joinNumber",joinNumber);
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }

// 项目信息
    @RequestMapping(value = "projectList.do")
    public ModelAndView projectList(IndexProjectSearchData indexProjectSearchData) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        PageData pageData = new PageData();
        PageInfo page = projectService.findExtendsByPage(indexProjectSearchData);
        List<ProjectExtends> projectExtendsList = page.getList();
        pageData.setPageNum(page.getPageNum());
        pageData.setPages(page.getPages());
        pageData.setIsFirstPage(page.isIsFirstPage());
        pageData.setIsLastPage(page.isIsLastPage());
        List<User> userList = userService.findAll();
        List<ProjectType> projectTypeList = projectTypeService.findAll();
        modelAndView.addObject("projectExtendsList",projectExtendsList);
        modelAndView.addObject("pageData",pageData);
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("projectTypeList",projectTypeList);
        modelAndView.addObject("ipsd",indexProjectSearchData);
        if(indexProjectSearchData.getProgress()!=null){
            modelAndView.setViewName("historyProjectList");
        }else {
            modelAndView.setViewName("projectList");
        }
        return modelAndView;
    }

    @RequestMapping(value = "projectListOfUserRelease.do")
    public ModelAndView projectListOfUserRelease(IndexProjectSearchData indexProjectSearchData) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByUserid(indexProjectSearchData.getReleaser());

        PageData pageData = new PageData();
        PageInfo pageInfo = projectService.findAllExtendsByPage(indexProjectSearchData);
        List<ProjectExtends> projectExtendsList = pageInfo.getList();
        pageData.setPageNum(pageInfo.getPageNum());
        pageData.setPages(pageInfo.getPages());
        pageData.setIsFirstPage(pageInfo.isIsFirstPage());
        pageData.setIsLastPage(pageInfo.isIsLastPage());
        List<ProjectType> projectTypeList = projectTypeService.findAll();
        modelAndView.addObject("user",user);
        modelAndView.addObject("projectExtendsList",projectExtendsList);
        modelAndView.addObject("pageData",pageData);
        modelAndView.addObject("projectTypeList",projectTypeList);
        modelAndView.addObject("ipsd",indexProjectSearchData);

        modelAndView.setViewName("projectListOfUserRelease");
        return modelAndView;
    }

    @RequestMapping(value = "projectListOfUserJoin.do")
    public ModelAndView projectListOfUserJoin(IndexProjectSearchData indexProjectSearchData) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByUserid(indexProjectSearchData.getMumber());

        PageData pageData = new PageData();
        PageInfo pageInfo = projectMumberService.findExtendsByMumber(indexProjectSearchData);
        List<ProjectMumberExtends> projectMumberExtendsList = pageInfo.getList();
        pageData.setPageNum(pageInfo.getPageNum());
        pageData.setPages(pageInfo.getPages());
        pageData.setIsFirstPage(pageInfo.isIsFirstPage());
        pageData.setIsLastPage(pageInfo.isIsLastPage());
        List<ProjectType> projectTypeList = projectTypeService.findAll();
        modelAndView.addObject("user",user);
        modelAndView.addObject("projectMumberExtendsList",projectMumberExtendsList);
        modelAndView.addObject("pageData",pageData);
        modelAndView.addObject("projectTypeList",projectTypeList);
        modelAndView.addObject("ipsd",indexProjectSearchData);

        modelAndView.setViewName("projectListOfUserJoin");
        return modelAndView;
    }

    @RequestMapping(value = "showProject.do")
    public ModelAndView showProject(Integer projectid,HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        String applicationFlag="";
        if(user!=null){
            Project project = projectService.findByProjectid(projectid);
            if(user.getUserid()==project.getReleaser()){
                applicationFlag="您是组长";
            }else {
                ApplicationProject applicationProject = applicationProjectService.findByApplicantAndProjectid(user.getUserid(), projectid);
                if(applicationProject!=null){
                    applicationFlag = applicationProject.getResult();
                }
            }
            if(project.getStatus().equals("冻结")){
                applicationFlag = project.getStatus();
            }
            if(project.getProgress()==100){
                applicationFlag="项目结束";
            }
        }
        ProjectExtends projectExtends = projectService.findExtendsByProjectid(projectid);
        Integer joined = projectMumberService.countByProjectid(projectid);
        //发布项目数以及参加项目数
        Integer releaseNumber = projectService.countReleaseNumber(projectExtends.getReleaser());
        Integer joinNumber = projectMumberService.countJoinNumber(projectExtends.getReleaser());
        modelAndView.addObject("projectExtends",projectExtends);
        modelAndView.addObject("joined",joined);
        modelAndView.addObject("applicationFlag",applicationFlag);
        modelAndView.addObject("releaseNumber",releaseNumber);
        modelAndView.addObject("joinNumber",joinNumber);
        modelAndView.setViewName("projectInfo");
        return modelAndView;
    }
}
