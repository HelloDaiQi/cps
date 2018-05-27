package com.daiqi.controller;

import com.daiqi.entity.ProjectType;
import com.daiqi.service.ProjectTypeService;
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
@RequestMapping(value = "type")
public class ProjectTypeController {
    @Resource
    private ProjectTypeService projectTypeService;

    @ResponseBody
    @RequestMapping(value = "listProjectType.do")
    public DataGrid<ProjectType> findProjectType(DataSearch dataSearch) throws Exception{
        DataGrid<ProjectType> dataGrid = new DataGrid<ProjectType>();
        PageInfo pageInfo=projectTypeService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editProjectType.do")
    public ModelAndView editProjectType(Integer typeid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        ProjectType projectType=projectTypeService.findByTypeid(typeid);
        modelAndView.addObject("type",projectType);
        modelAndView.setViewName("admin/form/projectTypeForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveProjectType.do")
    public ModelAndView saveProjectType(ProjectType projectType) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        if(projectType.getTypeid()==null){
            total=projectTypeService.saveProjectType(projectType);
        }else {
            total=projectTypeService.updateProjectType(projectType);
        }
        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/projectTypeManage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deleteProjectType.do")
    public Map deleteProjectType(Integer typeid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = projectTypeService.deleteProjectType(typeid);
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
