package com.daiqi.controller;

import com.daiqi.entity.Professional;
import com.daiqi.service.ProfessionalService;
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
@RequestMapping(value = "professional")
public class ProfessionalController {

    @Resource
    private ProfessionalService professionalService;

    @ResponseBody
    @RequestMapping(value = "listProfessional.do")
    public DataGrid<Professional> findProfessional(DataSearch dataSearch) throws Exception{
        DataGrid<Professional> dataGrid = new DataGrid<>();
        PageInfo pageInfo=professionalService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editProfessional.do")
    public ModelAndView editProfessional(Integer professionalid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Professional professional=professionalService.findByProfessionalid(professionalid);
        modelAndView.addObject("professional",professional);
        modelAndView.setViewName("admin/form/professionalForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveProfessional.do")
    public ModelAndView saveProfessional(Professional professional) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        if(professional.getProfessionalid()==null){
            total=professionalService.saveProfessional(professional);
        }else {
            total=professionalService.updateProfessional(professional);
        }
        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/professionalManage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deleteProfessional.do")
    public Map deleteProfessional(Integer professionalid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = professionalService.deleteProfessional(professionalid);
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
