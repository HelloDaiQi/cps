package com.daiqi.controller;

import com.daiqi.entity.*;
import com.daiqi.extend.UserExtends;
import com.daiqi.service.*;
import com.daiqi.util.CryptographyUtil;
import com.daiqi.util.PathUtil;
import com.daiqi.vo.DataGrid;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;


@Controller
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RoleService roleService;

    @Resource
    private SchoolService schoolService;

    @Resource
    private GradeService gradeService;

    @Resource
    private ProfessionalService professionalService;

    @Resource
    private SkillService skillService;

    @Resource
    private ProficiencyService skillProficiencyService;

    @ResponseBody
    @RequestMapping(value = "listUser.do")
    public DataGrid<User> findUser(DataSearch dataSearch,HttpSession session) throws Exception{
        session.setAttribute("userBage",0);

        DataGrid<User> dataGrid = new DataGrid<>();
        PageInfo pageInfo=userService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editUser.do")
    public ModelAndView editUser(Integer userid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        User user=userService.findByUserid(userid);
        List<School> schoolList = schoolService.findAll();
        List<Professional> professionalList  =professionalService.findAll();
        List<Grade> gradeList = gradeService.findAll();
        List<Skill> skillList = skillService.findAll();
        List<Proficiency> proficiencyList = skillProficiencyService.findAll();
        //角色
        List<UserRole> userRoleList1 = userid==null?null:userRoleService.findByUserid(userid);
        List<Role> roleList = roleService.findAll();
        List<Role> userRoleList = new ArrayList<>();
        if(userRoleList1!=null){
            for(UserRole userRole : userRoleList1){
                userRoleList.add(roleService.findByRoleid(userRole.getRoleid()));
            }
        }
        //防止选项重复出现
        for(int i=0;i<userRoleList.size();i++){
            for(int j=0;j<roleList.size();j++){
                if(userRoleList.get(i).getRoleid()==roleList.get(j).getRoleid()){
                    roleList.remove(j);
                }
            }
        }
        modelAndView.addObject("user",user);
        modelAndView.addObject("schoolList",schoolList);
        modelAndView.addObject("gradeList",gradeList);
        modelAndView.addObject("professionalList",professionalList);
        modelAndView.addObject("skillList",skillList);
        modelAndView.addObject("proficiencyList",proficiencyList);
        modelAndView.addObject("userRoleList",userRoleList);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("admin/form/userForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveUser.do")
    public ModelAndView saveUser(User user,Integer[] roleids){
        //System.out.println(user);
        ModelAndView modelAndView=new ModelAndView();
        Integer total1=0;
        Integer total2=0;
        try {
            if(user.getUserid()==null){
                //新添加用户，密码默认为123456
                user.setPassword(CryptographyUtil.md5("123456","daiqi"));
                user.setUserimage("cps/images/userImages/default.jpg");
                user.setRegistertime(new Date());
                user.setStatus("正常");
                total1 = userService.saveUser(user);
                //赋予角色
                UserRole userRole = new UserRole();
                for(int i=0;i<roleids.length;i++){
                    userRole.setUserid(user.getUserid());
                    userRole.setRoleid(roleids[i]);
                    total2 += userRoleService.saveUserRole(userRole);
                }
            }else {
                //我觉得吧，即使是管理员也不应该随便修改用户的密码
                total1 = userService.updateUser(user);
                //更改角色
                //在这里为了方便，我先把原来的角色关联统统删掉，然后在重新赋予其角色
                List<UserRole> userRoleList = userRoleService.findByUserid(user.getUserid());
                for(UserRole userRole : userRoleList){
                    userRoleService.deleteUserRole(userRole);
                }
                for(int i=0;i<roleids.length;i++){
                    UserRole userRole = new UserRole();
                    userRole.setUserid(user.getUserid());
                    userRole.setRoleid(roleids[i]);
                    total2 += userRoleService.saveUserRole(userRole);
                }
            }
            if(total1 > 0 && total2 == roleids.length){
                modelAndView.addObject("message","success");
            }else {
                modelAndView.addObject("message","failure");
            }
        }catch (Exception e){
            e.printStackTrace();
            modelAndView.addObject("message","failure");
        }finally {
            modelAndView.setViewName("admin/userManage");
            return modelAndView;
        }
    }

    @ResponseBody
    @RequestMapping(value = "uploadUserImage.do",method = RequestMethod.POST)
    public Map<String,Object> uploadUserImage(@RequestParam(value = "file", required = false)MultipartFile file,
                                              User user)throws Exception{
        Map<String,Object> res=new HashMap<>();
        if(file != null){
            //文件上传的保存路径
            String path="F:\\mysrc\\";
            //图片的原始名称（不含路径）
            String origanlFileName = file.getOriginalFilename();
            //得到随机目录
            String timeDir= "cps/images/userImages/"+PathUtil.getPathByTime();
            String randomDir=path+timeDir;
            //判断目录是否存在
            File parentDir = new File(randomDir);
            if(!parentDir.exists()){
                parentDir.mkdirs();
            }
            //上传的图片的保存的新名称，随机生成文件名称+.jpg
            String newFileName = UUID.randomUUID()+origanlFileName.substring(origanlFileName.lastIndexOf("."));
            File newFile = new File(parentDir,newFileName);
            //将内存的数据写到磁盘上
            file.transferTo(newFile);

            //将路径写到数据库
            String userImageUrl=timeDir+newFileName;
            user.setUserimage(userImageUrl);
            userService.updateUser(user);

            res.put("code",200);
            res.put("msg","success");
            res.put("data",new HashMap<String,Object>(){
                {
                    put("src",userImageUrl);
                }
            });
        }else {
            res.put("code",500);
            res.put("msg","false");
            res.put("data",new HashMap<String,Object>(){
                {
                    put("src","");
                }
            });
        }
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "changeUserStatus.do")
    public Map changeUserStatus(User user) throws Exception{
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        if(user.getStatus().equals("正常")){
            user.setStatus("冻结");
            total=userService.updateUser(user);
        }else if(user.getStatus().equals("冻结")){
            user.setStatus("正常");
            total=userService.updateUser(user);
        }
        if(total>0){
            res.put("json","success");
        }else{
            res.put("json","false");
        }
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "deleteUser.do")
    public Map deleteUser(Integer userid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = userService.deleteUser(userid);
            if(total>0){
                res.put("json","success");
            }else{
                res.put("json","false");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("json","false");
        }

        return res;
    }

    //-------------------------------------------
    @RequestMapping(value = "userselfInfo.do")
    public ModelAndView userselfInfo(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        UserExtends userExtends = userService.findExtendsByUserid(user.getUserid());
        modelAndView.addObject("userExtends",userExtends);
        modelAndView.setViewName("user/userselfInfo");
        return modelAndView;
    }

    @RequestMapping(value = "editUserselfInfo.do")
    public ModelAndView editUserselfInfo(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        UserExtends userExtends = userService.findExtendsByUserid(user.getUserid());
        List<School> schoolList = schoolService.findAll();
        List<Professional> professionalList  =professionalService.findAll();
        List<Grade> gradeList = gradeService.findAll();
        List<Skill> skillList = skillService.findAll();
        List<Proficiency> proficiencyList = skillProficiencyService.findAll();
        modelAndView.addObject("userExtends",userExtends);
        modelAndView.addObject("schoolList",schoolList);
        modelAndView.addObject("gradeList",gradeList);
        modelAndView.addObject("professionalList",professionalList);
        modelAndView.addObject("skillList",skillList);
        modelAndView.addObject("proficiencyList",proficiencyList);
        modelAndView.setViewName("user/editUserselfInfo");
        return modelAndView;
    }

    @RequestMapping(value = "saveUserselfInfo.do")
    public ModelAndView saveUserselfInfo(User user, MultipartFile file) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
//        long size = file.getSize();
//        boolean empty = file.isEmpty();
        if(file != null &&file.getSize()>0){
            //文件上传的保存路径
            String path="F:\\mysrc\\";
            //图片的原始名称（不含路径）
            String origanlFileName = file.getOriginalFilename();
            //得到随机目录
            String timeDir= "cps/images/userImages/"+ PathUtil.getPathByTime();
            String randomDir=path+timeDir;
            //判断目录是否存在
            File parentDir = new File(randomDir);
            if(!parentDir.exists()){
                parentDir.mkdirs();
            }
            //上传的图片的保存的新名称，随机生成文件名称+.jpg
            String newFileName = UUID.randomUUID()+origanlFileName.substring(origanlFileName.lastIndexOf("."));
            File newFile = new File(parentDir,newFileName);
            //将内存的数据写到磁盘上
            file.transferTo(newFile);

            //将路径写到数据库
            String userImageUrl=timeDir+newFileName;
            user.setUserimage(userImageUrl);
            userService.updateUser(user);
        }else{
            userService.updateUser(user);
        }
        UserExtends userExtends = userService.findExtendsByUserid(user.getUserid());
        modelAndView.addObject("userExtends",userExtends);
        modelAndView.setViewName("user/userselfInfo");
        return modelAndView;
    }

    //修改该用户密码
    @RequestMapping(value = "updateUserPasswordInfo.do")
    public ModelAndView updateUserPasswordInfo() throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user/updateUserPasswordInfo");
        return modelAndView;
    }

    @RequestMapping(value = "updateUserPassword.do")
    public ModelAndView updateUserPassword(User user, HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Integer result=0;
        User user1 = (User) session.getAttribute("user");
        user.setUserid(user1.getUserid());
        user.setPassword(CryptographyUtil.md5(user.getPassword(),"daiqi"));
        result = userService.updateUser(user);
        if(result>0){
            modelAndView.addObject("message","密码修改成功，请重新登录！");
        }else {
            modelAndView.addObject("message","密码修改失败，请重新登录！");
        }
        modelAndView.setViewName("tip");
        return modelAndView;
    }

    //修改管理员信息
    @RequestMapping(value = "editAdmin.do")
    public ModelAndView editAdmin(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        user = userService.findByUserid(user.getUserid());
        //角色
        List<UserRole> userRoleList1 = userRoleService.findByUserid(user.getUserid());
        List<Role> userRoleList = new ArrayList<>();
        if(userRoleList1!=null){
            for(UserRole userRole : userRoleList1){
                userRoleList.add(roleService.findByRoleid(userRole.getRoleid()));
            }
        }
        List<Role> roleList = roleService.findAll();
        //防止选项重复出现
        for(int i=0;i<userRoleList.size();i++){
            for(int j=0;j<roleList.size();j++){
                if(userRoleList.get(i).getRoleid()==roleList.get(j).getRoleid()){
                    roleList.remove(j);
                }
            }
        }
        modelAndView.addObject("user",user);
        modelAndView.addObject("userRoleList",userRoleList);
        modelAndView.addObject("roleList",roleList);

        modelAndView.setViewName("admin/form/adminForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveAdmin.do")
    public ModelAndView saveAdmin(User user,Integer[] roleids){
        ModelAndView modelAndView=new ModelAndView();
        Integer total1=0;
        Integer total2=0;
        try {
            total1 = userService.updateUser(user);
            //更改角色
            //在这里为了方便，我先把原来的角色关联统统删掉，然后在重新赋予其角色
            List<UserRole> userRoleList = userRoleService.findByUserid(user.getUserid());
            for(UserRole userRole : userRoleList){
                userRoleService.deleteUserRole(userRole);
            }
            for(int i=0;i<roleids.length;i++){
                UserRole userRole = new UserRole();
                userRole.setUserid(user.getUserid());
                userRole.setRoleid(roleids[i]);
                total2 += userRoleService.saveUserRole(userRole);
            }
            if(total1 > 0 && total2 == roleids.length){
                modelAndView.addObject("message","success");
            }else {
                modelAndView.addObject("message","failure");
            }
        }catch (Exception e){
            e.printStackTrace();
            modelAndView.addObject("message","failure");
        }finally {
            modelAndView.setViewName("admin/adminSuccess");
            return modelAndView;
        }
    }

    @RequestMapping(value = "updateAdminPasswordForm.do")
    public ModelAndView updateAdminPasswordForm(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        user = userService.findByUserid(user.getUserid());

        modelAndView.addObject("user",user);
        modelAndView.setViewName("admin/form/updateAdminPasswordForm");
        return modelAndView;
    }

    @RequestMapping(value = "updateAdminPassword.do")
    public ModelAndView updateAdminPassword(User user) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Integer result=0;
        user.setPassword(CryptographyUtil.md5(user.getPassword(),"daiqi"));
        result = userService.updateUser(user);
        if(result > 0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/adminSuccess");
        return modelAndView;
    }
}
