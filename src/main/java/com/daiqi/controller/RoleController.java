package com.daiqi.controller;

import com.daiqi.entity.Role;
import com.daiqi.service.RoleService;
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
@RequestMapping(value = "role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "listRole.do")
    public DataGrid<Role> listRole(DataSearch dataSearch) throws Exception{
        DataGrid<Role> dataGrid = new DataGrid<>();
        PageInfo pageInfo=roleService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editRole.do")
    public ModelAndView editRole(Integer roleid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.setViewName("admin/form/roleForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveRole.do")
    public ModelAndView saveRole(Role role) throws Exception{
        System.out.println(role);
        Integer total=0;
        ModelAndView modelAndView=new ModelAndView();
        if(role.getRoleid()==null){
            total = roleService.saveRole(role);
        }else {
            total = roleService.update(role);
        }
        if(total>0){
            modelAndView.addObject("message","success");
        }else {
            modelAndView.addObject("message","failure");
        }
        modelAndView.setViewName("admin/roleManage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deleteRole.do")
    public Map deleteSkill(Integer roleid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = roleService.deleteRole(roleid);
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
