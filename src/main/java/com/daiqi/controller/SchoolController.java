package com.daiqi.controller;

import com.daiqi.entity.School;
import com.daiqi.service.SchoolService;
import com.daiqi.vo.DataGrid;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "school")
public class SchoolController {

    @Resource
    private SchoolService schoolService;

    @ResponseBody
    @RequestMapping(value = "listSchool.do")
    public DataGrid<School> findSchool(DataSearch dataSearch) throws Exception{
        DataGrid<School> dataGrid = new DataGrid<School>();
        PageInfo pageInfo=schoolService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editSchool.do")
    public ModelAndView editSchool(Integer schoolid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        School school=schoolService.findBySchoolid(schoolid);
        modelAndView.addObject("school",school);
        modelAndView.setViewName("admin/form/schoolForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveSchool.do")
    public ModelAndView saveSchool(School school) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        if(school.getSchoolid()==null){
            total=schoolService.saveSchool(school);
        }else {
            total=schoolService.updateSchool(school);
        }
        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/schoolManage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deleteSchool.do")
    public Map deleteSchool(Integer schoolid) {
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = schoolService.deleteSchool(schoolid);
            if(total>0){
                res.put("json","success");
            }else{
                res.put("json","false");
            }
        }catch (Exception e){
            e.printStackTrace();
            res.put("json","对不起，您不能删除这条数据！");
        }
        return res;
    }
}
