package com.daiqi.controller;

import com.daiqi.entity.Grade;
import com.daiqi.service.GradeService;
import com.daiqi.vo.DataGrid;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "grade")
public class GradeController {
    @Resource
    private GradeService gradeService;

    @ResponseBody
    @RequestMapping(value = "listGrade.do")
    public DataGrid<Grade> findGrade(DataSearch dataSearch) throws Exception{
        DataGrid<Grade> dataGrid = new DataGrid<>();
        PageInfo pageInfo=gradeService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editGrade.do")
    public ModelAndView editGrade(Integer gradeid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Grade grade=gradeService.findByGradeid(gradeid);
        modelAndView.addObject("grade",grade);
        modelAndView.setViewName("admin/form/gradeForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveGrade.do")
    public ModelAndView saveGrade(Grade grade) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        if(grade.getGradeid()==null){
            total=gradeService.saveGrade(grade);
        }else {
            total=gradeService.updateGrade(grade);
        }
        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/gradeManage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deleteGrade.do")
    public Map deleteGrade(Integer gradeid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = gradeService.deleteGrade(gradeid);
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
}
