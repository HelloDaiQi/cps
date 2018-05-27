package com.daiqi.controller;

import com.daiqi.entity.*;
import com.daiqi.extend.ApplicationProjectExtends;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.extend.ProjectMumberExtends;
import com.daiqi.service.*;
import com.daiqi.util.PathUtil;
import com.daiqi.vo.DataGrid;
import com.daiqi.vo.DataSearch;
import com.daiqi.vo.IndexProjectSearchData;
import com.daiqi.vo.PageData;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping(value = "project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @Resource
    private CertificationUserService certificationUserService;

    @Resource
    private ProjectTypeService projectTypeService;

    @Resource
    ProjectMumberService projectMumberService;

    @Resource
    private UserService userService;

    @Resource
    private ApplicationProjectService applicationProjectService;

    @ResponseBody
    @RequestMapping(value = "listProject.do")
    public DataGrid<Project> findUser(DataSearch dataSearch,HttpSession session) throws Exception{
        session.setAttribute("projectBage",0);

        DataGrid<Project> dataGrid = new DataGrid<>();
        PageInfo pageInfo=projectService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editProject.do")
    public ModelAndView editProject(Integer projectid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Project project = projectService.findByProjectid(projectid);
        List<CertificationUser> cUserList = certificationUserService.findAll();
        List<ProjectType> projectTypeList = projectTypeService.findAll();
        modelAndView.addObject("project",project);
        modelAndView.addObject("cUserList",cUserList);
        modelAndView.addObject("projectTypeList",projectTypeList);
        modelAndView.setViewName("admin/form/projectForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveProject.do")
    public ModelAndView saveProject(Project project,Integer[] progresses) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        if(progresses!=null&&progresses.length>=1){
            Integer progress = progresses[progresses.length-1];
            project.setProgress(progress);
            if(progress==100){
                project.setStoptime(new Date());
            }
        }
        if(project.getProjectid()==null){
            project.setProjectimage("cps/images/userImages/default.jpg");
            project.setStatus("正常");
            if(project.getProgress()==null){
                project.setProgress(0);
            }
            total=projectService.saveProject(project);
        }else {
            total=projectService.updateProject(project);
        }

        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/projectManage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "uploadProjectImage.do",method = RequestMethod.POST)
    public Map<String,Object> uploadProjectImage(@RequestParam(value = "file", required = false)MultipartFile file,
                                              Project project)throws Exception{
        Map<String,Object> res=new HashMap<String,Object>();
        if(file != null){
            //文件上传的保存路径
            String path="F:\\mysrc\\";
            //图片的原始名称（不含路径）
            String origanlFileName = file.getOriginalFilename();
            //得到随机目录
            String timeDir= "cps/images/projectImages/"+ PathUtil.getPathByTime();
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
            String projectImageUrl=timeDir+newFileName;
            project.setProjectimage(projectImageUrl);
            projectService.updateProject(project);

            res.put("code",200);
            res.put("msg","success");
            res.put("data",new HashMap<String,Object>(){
                {
                    put("src",projectImageUrl);
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
    @RequestMapping(value = "changeProjectStatus.do")
    public Map changeProjectStatus(Project project) throws Exception{
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        if(project.getStatus().equals("正常")){
            project.setStatus("冻结");
            total=projectService.updateProject(project);
        }else if(project.getStatus().equals("冻结")){
            project.setStatus("正常");
            total=projectService.updateProject(project);
        }
        if(total>0){
            res.put("json","success");
        }else{
            res.put("json","false");
        }
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "deleteProject.do")
    public Map deleteProject(Integer projectid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = projectService.deleteProject(projectid);
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

    @RequestMapping(value = "showProject.do")
    public ModelAndView showProject(Integer projectid) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Project project = projectService.findByProjectid(projectid);
        List<CertificationUser> cUserList = certificationUserService.findAll();
        List<ProjectType> projectTypeList = projectTypeService.findAll();
        List<ProjectMumber> projectMumberList = projectMumberService.findByProjectid(projectid);
        List<User> userList = new ArrayList<>();
        for (ProjectMumber projectMumber:projectMumberList){
            User user = userService.findByUserid(projectMumber.getUserid());
            userList.add(user);
        }
        modelAndView.addObject("project",project);
        modelAndView.addObject("cUserList",cUserList);
        modelAndView.addObject("projectTypeList",projectTypeList);
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("admin/form/showProjectForm");

        return modelAndView;
    }

    @RequestMapping(value="rproject.do")
    public ModelAndView rproject(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        CertificationUser cuser = certificationUserService.findByUserid(user.getUserid());
        if(cuser!=null){
            if (cuser.getStatus().equals("审核通过")){
                List<ProjectType> projectTypeList = projectTypeService.findAll();
                modelAndView.addObject("projectTypeList",projectTypeList);
            }else {
                modelAndView.addObject("message","您的认证信息暂未通过");
            }
        }else {
            modelAndView.addObject("message","您还未认证");
        }
        modelAndView.setViewName("user/rproject");
        return modelAndView;
    }

    @RequestMapping(value = "saveRproject.do")
    public ModelAndView saveRproject(Project project, MultipartFile file,HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        //奇了个葩的了，我为什么要写这句啊，好像没啥用啊
        //CertificationUser cuser = certificationUserService.findByUserid(user.getUserid());
        project.setReleaser(user.getUserid());
        project.setProjectimage("cps/images/projectImages/default.jpg");
        project.setReleasetime(new Date());
        project.setProgress(0);
        project.setStatus("正常");
        if(file != null && file.getSize()>0){
            //文件上传的保存路径
            String path="F:\\mysrc\\";
            //图片的原始名称（不含路径）
            String origanlFileName = file.getOriginalFilename();
            //得到随机目录
            String timeDir= "cps/images/projectImages/"+ PathUtil.getPathByTime();
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
            String projectImageUrl=timeDir+newFileName;
            project.setProjectimage(projectImageUrl);
            if(project.getProjectid()==null){
                projectService.saveProject(project);
            }else {
                projectService.updateProject(project);
            }
        }else{
            if(project.getProjectid()==null){
                projectService.saveProject(project);
            }else {
                projectService.updateProject(project);
            }
        }
        //UserExtends userExtends = userService.findExtendsByUserid(user.getUserid());
        //modelAndView.addObject("userExtends",userExtends);

        modelAndView.setViewName("user/rprojectInfo");
        return modelAndView;
    }

    /*我发布的项目*/
    @RequestMapping(value="rprojectInfo.do")
    public ModelAndView rprojectInfo(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        session.setAttribute("RprojectInfoBadge",0);

        modelAndView.setViewName("user/rprojectInfo");
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value="rprojectInfoList.do")
    public DataGrid rprojectInfoList(HttpSession session) throws Exception{
        DataGrid<ProjectExtends> dataGrid = new DataGrid();
        User user = (User) session.getAttribute("user");
        List<ProjectExtends> projectExtendsList = projectService.findExtendsByReleaser(user.getUserid());
        for(ProjectExtends projectExtends:projectExtendsList){
            List<ProjectMumberExtends> ProjectMumberExtendsList = projectMumberService.findExtendsByProjectid(projectExtends.getProjectid());
            List<ApplicationProjectExtends> applicationProjectExtendsList = applicationProjectService.findExtendsByProjectid(projectExtends.getProjectid());
            projectExtends.setProjectMumberExtensList(ProjectMumberExtendsList);
            projectExtends.setApplicationProjectExtendsList(applicationProjectExtendsList);
        }
        dataGrid.setData(projectExtendsList);
        return dataGrid;
    }

    @RequestMapping(value="historyRprojectInfo.do")
    public ModelAndView historyRprojectInfo() throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user/historyRprojectInfo");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="historyRprojectInfoList.do")
    public DataGrid historyRprojectInfoList(HttpSession session) throws Exception{
        DataGrid<ProjectExtends> dataGrid = new DataGrid();
        User user = (User) session.getAttribute("user");
        List<ProjectExtends> projectExtendsList = projectService.findHistoryExtendsByReleaser(user.getUserid());
        for(ProjectExtends projectExtends:projectExtendsList){
            List<ProjectMumberExtends> ProjectMumberExtendsList = projectMumberService.findExtendsByProjectid(projectExtends.getProjectid());
            List<ApplicationProjectExtends> applicationProjectExtendsList = applicationProjectService.findExtendsByProjectid(projectExtends.getProjectid());
            projectExtends.setProjectMumberExtensList(ProjectMumberExtendsList);
            projectExtends.setApplicationProjectExtendsList(applicationProjectExtendsList);
        }
        dataGrid.setData(projectExtendsList);
        return dataGrid;
    }

    @RequestMapping(value = "updateRprojectInfo.do")
    public ModelAndView UpdateRproject(Integer projectid) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        ProjectExtends projectExtends = projectService.findExtendsByProjectid(projectid);
        List<ProjectType> projectTypeList = projectTypeService.findAll();
        modelAndView.addObject("projectExtends",projectExtends);
        modelAndView.addObject("projectTypeList",projectTypeList);
        modelAndView.setViewName("user/updateRprojectInfo");
        return modelAndView;
    }

    @RequestMapping(value = "updateRproject.do")
    public ModelAndView updateRproject(Project project,Integer[] progresses) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        //使用disabled，复选框的值便不会传入后台
        if(progresses!=null&&progresses.length>=1){
            Integer progress = progresses[progresses.length-1];
            project.setProgress(progress);
            if(progress == 100){
                project.setStoptime(new Date());
            }
        }
        Integer result = projectService.updateProject(project);
        modelAndView.addObject("result",result);
        modelAndView.setViewName("user/rprojectInfo");
        return modelAndView;
    }

    /*我申请的项目*/
    @RequestMapping(value = "aprojectInfo.do")
    public ModelAndView aprojectInfo(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");

        modelAndView.setViewName("user/aprojectInfo");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="aprojectInfoList.do")
    public DataGrid aprojectInfoList(HttpSession session) throws Exception{
        DataGrid<ApplicationProjectExtends> dataGrid = new DataGrid();
        User user = (User) session.getAttribute("user");
        List<ApplicationProjectExtends> aprojectExtendsList = applicationProjectService.findByApplicant(user.getUserid());
        dataGrid.setData(aprojectExtendsList);
        return dataGrid;
    }

    /*我参加的项目*/
    @RequestMapping(value = "jprojectInfo.do")
    public ModelAndView jprojectInfo(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");

        modelAndView.setViewName("user/jprojectInfo");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="jprojectInfoList.do")
    public DataGrid jprojectInfoList(HttpSession session) throws Exception{
        DataGrid<ProjectMumberExtends> dataGrid = new DataGrid();
        User user = (User) session.getAttribute("user");
        List<ProjectMumberExtends> projectMumberExtendsList = projectMumberService.findExtendsByUserid(user.getUserid());
        for(ProjectMumberExtends projectMumberExtends:projectMumberExtendsList){
            List<ProjectMumberExtends> projectMumberExtendsList1 = projectMumberService.findExtendsByProjectid(projectMumberExtends.getProjectid());
            projectMumberExtends.getProjectExtends().setProjectMumberExtensList(projectMumberExtendsList1);
        }
        dataGrid.setData(projectMumberExtendsList);
        return dataGrid;
    }
}
