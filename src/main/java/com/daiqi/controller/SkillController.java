package com.daiqi.controller;

import com.daiqi.entity.Skill;
import com.daiqi.service.SkillService;
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
@RequestMapping(value = "skill")
public class SkillController {
    @Resource
    private SkillService skillService;

    @ResponseBody
    @RequestMapping(value = "listSkill.do")
    public DataGrid<Skill> findSkill(DataSearch dataSearch) throws Exception{
        DataGrid<Skill> dataGrid = new DataGrid<>();
        PageInfo pageInfo=skillService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editSkill.do")
    public ModelAndView editSkill(Integer skillid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Skill skill=skillService.findBySkillid(skillid);
        modelAndView.addObject("skill",skill);
        modelAndView.setViewName("admin/form/skillForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveSkill.do")
    public ModelAndView saveSkill(Skill skill) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        if(skill.getSkillid()==null){
            total=skillService.saveSkill(skill);
        }else {
            total=skillService.updateSkill(skill);
        }
        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/skillManage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deleteSkill.do")
    public Map deleteSkill(Integer skillid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = skillService.deleteSkill(skillid);
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
