package com.daiqi.controller;

import com.daiqi.entity.Proficiency;
import com.daiqi.service.ProficiencyService;
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
@RequestMapping(value = "proficiency")
public class ProficiencyController {
    @Resource
    private ProficiencyService proficiencyService;

    @ResponseBody
    @RequestMapping(value = "listProficiency.do")
    public DataGrid<Proficiency> findProficiency(DataSearch dataSearch) throws Exception{
        DataGrid<Proficiency> dataGrid = new DataGrid<Proficiency>();
        PageInfo pageInfo=proficiencyService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editProficiency.do")
    public ModelAndView editProficiency(Integer proficiencyid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Proficiency proficiency=proficiencyService.findByProficiencyid(proficiencyid);
        modelAndView.addObject("proficiency",proficiency);
        modelAndView.setViewName("admin/form/proficiencyForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveProficiency.do")
    public ModelAndView saveProficiency(Proficiency proficiency) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        if(proficiency.getProficiencyid()==null){
            total=proficiencyService.saveProficiency(proficiency);
        }else {
            total=proficiencyService.updateProficiency(proficiency);
        }
        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/proficiencyManage");
        return modelAndView;
    }

    @RequestMapping(value = "deleteProficiency.do")
    public Map deleteProficiency(Integer proficiencyid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = proficiencyService.deleteProficiency(proficiencyid);
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
