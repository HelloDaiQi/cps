package com.daiqi.controller;

import com.daiqi.entity.*;
import com.daiqi.service.CertificationUserService;
import com.daiqi.service.GradeService;
import com.daiqi.service.SchoolService;
import com.daiqi.service.UserService;
import com.daiqi.vo.DataGrid;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "cuser")
public class CuserController {

    @Resource
    private CertificationUserService certificationUserService;

    @Resource
    private UserService userService;

    @Resource
    private SchoolService schoolService;

    @Resource
    private GradeService gradeService;

    @ResponseBody
    @RequestMapping(value = "listCuser.do")
    public DataGrid<CertificationUser> findCertificationUser(DataSearch dataSearch,HttpSession session) throws Exception{
        session.setAttribute("cuserBage",0);

        DataGrid<CertificationUser> dataGrid = new DataGrid<>();
        PageInfo pageInfo=certificationUserService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editCuser.do")
    public ModelAndView editCertificationUser(Integer cuserid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        CertificationUser cuser=certificationUserService.findByCuserid(cuserid);
        User user = userService.findByUserid(cuser.getUserid());
        List<School> schoolList = schoolService.findAll();
        List<Grade> gradeList = gradeService.findAll();
        modelAndView.addObject("cuser",cuser);
        modelAndView.addObject("user",user);
        modelAndView.addObject("schoolList",schoolList);
        modelAndView.addObject("gradeList",gradeList);
        modelAndView.setViewName("admin/form/cuserForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveCuser.do")
    public ModelAndView saveCuser(CertificationUser cuser,String check) throws Exception{
        Integer total=0;
        if(check.equals("审核不通过")){
            cuser.setStatus("审核不通过");
            total=certificationUserService.updateCuser(cuser);
        }else if(check.equals("审核通过")){
            cuser.setStatus("审核通过");
            total=certificationUserService.updateCuser(cuser);
        }
        ModelAndView modelAndView=new ModelAndView();
        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/cuserManage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deleteCuser.do")
    public Map deleteCuser(Integer cuserid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = certificationUserService.deleteCuser(cuserid);
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

    //---------------------------
    @RequestMapping(value = "editCuserselfInfo.do")
    public ModelAndView editCuserselfInfo(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        CertificationUser cuser = certificationUserService.findByUserid(user.getUserid());
        modelAndView.addObject("cuser",cuser);
        modelAndView.setViewName("user/cuserselfInfo");
        return modelAndView;
    }

    @RequestMapping(value = "saveCuserselfInfo.do")
    public ModelAndView saveCuserselfInfo(CertificationUser cuser,HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        Integer result = 0;
        cuser.setCertificationtime(new Date());
        cuser.setStatus("审核中");
        if(cuser.getCuserid()!=null){
            result = certificationUserService.updateCuser(cuser);
        }else {
            cuser.setUserid(user.getUserid());
            result = certificationUserService.saveCuser(cuser);
        }
        if(result>0){
            modelAndView.addObject("cuser",cuser);
            modelAndView.addObject("message","提交成功！");
        }else{
            modelAndView.addObject("message","提交失败！");
        }
        modelAndView.setViewName("user/cuserselfInfo");
        return modelAndView;
    }
}
