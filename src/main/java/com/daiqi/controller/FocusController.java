package com.daiqi.controller;

import com.daiqi.entity.Focus;
import com.daiqi.entity.User;
import com.daiqi.extend.UserExtends;
import com.daiqi.service.FocusService;
import com.daiqi.service.UserService;
import com.daiqi.vo.DataGrid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping(value = "focus")
public class FocusController {

    @Resource
    private UserService userService;

    @Resource
    private FocusService focusService;

    @RequestMapping(value = "focusList.do")
    public ModelAndView focusList() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/focusInfo");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "focusUserList.do")
    public DataGrid focusUserList(HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        DataGrid<User> dataGrid = new DataGrid<>();
        List<User> data = new ArrayList<>();
        List<Focus> focusList = focusService.findFocusByUserid(user.getUserid());
        for(Focus focus:focusList){
            User user1 = userService.findByUserid(focus.getBefocuser());
            data.add(user1);
        }
        dataGrid.setData(data);
        return dataGrid;
    }

    @RequestMapping(value = "focusHim.do")
    public ModelAndView focusHim(Integer befocuser,String flag,HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        if(flag.equals("focusHim")){
            Focus focus = new Focus();
            focus.setFocuser(user.getUserid());
            focus.setBefocuser(befocuser);
            focus.setFocustime(new Date());
            Integer result = focusService.saveFocus(focus);
        }else if(flag.equals("notFocusHim")){
            Integer result = focusService.deleteByFocuserAndBefocuser(user.getUserid(),befocuser);
        }

        UserExtends userExtends = userService.findExtendsByUserid(befocuser);
        Boolean isFocus = focusService.isFocused(user.getUserid(),befocuser);
        modelAndView.addObject("userExtends",userExtends);
        modelAndView.addObject("isFocus",isFocus);
        modelAndView.setViewName("userInfo");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deletefocus.do")
    public Map deletefocus(Integer userid,HttpSession session) throws Exception{
        Map<String,Object> res=new HashMap<>();
        User user = (User) session.getAttribute("user");
        Integer total=0;
        total = focusService.deleteByFocuserAndBefocuser(user.getUserid(),userid);
        if(total>0){
            res.put("json","success");
        }else{
            res.put("json","false");
        }
        return res;
    }
}
