package com.daiqi.controller;

import com.daiqi.entity.ApplicationProject;
import com.daiqi.entity.Project;
import com.daiqi.entity.ProjectMumber;
import com.daiqi.entity.User;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.service.ApplicationProjectService;
import com.daiqi.service.ProjectMumberService;
import com.daiqi.service.ProjectService;
import com.daiqi.service.UserService;
import com.daiqi.vo.DataGrid;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "aproject")
public class AprojectController {

    @Resource
    private ApplicationProjectService aprojectService;

    @Resource
    private UserService userService;

    @Resource
    private ProjectService projectService;

    @Resource
    ProjectMumberService projectMumberService;

    @Resource
    private ApplicationProjectService applicationProjectService;

    @ResponseBody
    @RequestMapping(value = "listAproject.do")
    public DataGrid<ApplicationProject> findAproject(DataSearch dataSearch) throws Exception{
        DataGrid<ApplicationProject> dataGrid = new DataGrid<>();
        PageInfo pageInfo=aprojectService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editAproject.do")
    public ModelAndView editAproject(Integer aprojectid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        ApplicationProject aproject=aprojectService.findByAprojectid(aprojectid);
        User user = userService.findByUserid(aproject.getApplicant());
        Project project = projectService.findByProjectid(aproject.getProjectid());
        modelAndView.addObject("aproject",aproject);
        modelAndView.addObject("user",user);
        modelAndView.addObject("project",project);
        modelAndView.setViewName("admin/form/aprojectForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveAproject.do")
    public ModelAndView saveAproject(ApplicationProject aproject) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        if(aproject.getAprojectid()==null){
            total=aprojectService.saveAproject(aproject);
        }else {
            total=aprojectService.updateAproject(aproject);
        }
        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/aprojectManage");
        return modelAndView;
    }

    @RequestMapping(value = "deleteApplicationProject.do")
    public ModelAndView deleteApplicationPproject(Integer aprojectid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
//        total = aprojectService.deletApplicationProject(aprojectid);
//        if(total>0){
//            modelAndView.addObject("message","success");
//        }else {
//            modelAndView.addObject("message","failure");
//        }
        modelAndView.setViewName("admin/aprojectManage");
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value="checkUser.do")
    public Map checkUser(ApplicationProject aproject,String type) throws Exception{
        Map<String,Object> json = new HashMap<>();
        if(aproject.getAprojectid()!=null){
            ApplicationProject applicationProject = aprojectService.findByAprojectid(aproject.getAprojectid());
            if(type.equals("allow")){
                applicationProject.setResult("审核通过");
                aprojectService.updateAproject(applicationProject);
                ProjectMumber projectMumber = new ProjectMumber();
                projectMumber.setProjectid(applicationProject.getProjectid());
                projectMumber.setUserid(applicationProject.getApplicant());
                Integer result = projectMumberService.saveProjectMumber(projectMumber);
                if(result>0){
                    json.put("json","success");
                }else {
                    json.put("json","error");
                }
            }else if(type.equals("deny")){
                applicationProject.setResult("审核不通过");
                aprojectService.updateAproject(applicationProject);
                json.put("json","success");
            }else {
                json.put("json","error");
            }
        }else {
            json.put("json","error");
        }
        return json;
    }

    @RequestMapping(value = "applyProject.do")
    public ModelAndView applyProject(Integer projectid, String flag, String reason, HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        if(user.getStatus().equals("正常")){
            if(flag.equals("apply")){
                ApplicationProject applicationProject = new ApplicationProject();
                applicationProject.setApplicant(user.getUserid());
                applicationProject.setProjectid(projectid);
                applicationProject.setReason(reason);
                applicationProject.setApplicationtime(new Date());
                applicationProject.setResult("审核中");
                Integer result = aprojectService.saveAproject(applicationProject);
            }else if(flag.equals("applyAgain")){
                ApplicationProject applicationProject = aprojectService.findByApplicantAndProjectid(user.getUserid(),projectid);
                if(applicationProject!=null){
                    applicationProject.setReason(reason);
                    applicationProject.setApplicationtime(new Date());
                    applicationProject.setResult("审核中");
                    Integer result = aprojectService.updateAproject(applicationProject);
                }
            }
        }else {
            modelAndView.addObject("message","您的账号异常！");
        }

        String applicationFlag="";
        Project project = projectService.findByProjectid(projectid);
        if(user.getUserid()==project.getReleaser()){
            applicationFlag="您是组长";
        }else {
            ApplicationProject applicationProject = applicationProjectService.findByApplicantAndProjectid(user.getUserid(), projectid);
            if(applicationProject!=null){
                applicationFlag = applicationProject.getResult();
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

    @ResponseBody
    @RequestMapping(value = "deleteAproject.do")
    public Map deleteAproject(Integer aprojectid) throws Exception{
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        total = aprojectService.deleteByAprojectid(aprojectid);
        if(total>0){
            res.put("json","success");
        }else{
            res.put("json","false");
        }
        return res;
    }
}
