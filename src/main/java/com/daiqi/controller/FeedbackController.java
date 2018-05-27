package com.daiqi.controller;

import com.daiqi.entity.Feedback;
import com.daiqi.entity.School;
import com.daiqi.entity.User;
import com.daiqi.service.FeedbackService;
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
@RequestMapping(value = "feedback")
public class FeedbackController {

    @Resource
    private FeedbackService feedbackService;

    @Resource
    private UserService userService;

    @Resource
    private SchoolService schoolService;

    @ResponseBody
    @RequestMapping(value = "listFeedback.do")
    public DataGrid<Feedback> findFeedback(DataSearch dataSearch,HttpSession session) throws Exception{
        //新增功能，将提示徽章去掉
        session.setAttribute("feedbackBage",0);
        DataGrid<Feedback> dataGrid = new DataGrid<>();
        PageInfo pageInfo=feedbackService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editFeedback.do")
    public ModelAndView editFeedback(Integer feedbackid) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Feedback feedback=feedbackService.findByFeedbackid(feedbackid);
        User user = userService.findByUserid(feedback.getFeedbackperson());
        List<School> schoolList = schoolService.findAll();
        modelAndView.addObject("feedback",feedback);
        modelAndView.addObject("user",user);
        modelAndView.addObject("schoolList",schoolList);
        modelAndView.setViewName("admin/form/feedbackForm");
        return modelAndView;
    }

    @RequestMapping(value = "saveFeedback.do")
    public ModelAndView saveFeedback(Feedback feedback, HttpSession session) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        User user = (User) session.getAttribute("user");
        if(user!=null){
            if(feedback.getFeedbackid()==null){
                feedback.setFeedbackperson(user.getUserid());
                feedback.setFeedbacktime(new Date());
                feedback.setResult("处理中");
                total=feedbackService.saveFeedback(feedback);
            }else {
                total=feedbackService.updateFeedback(feedback);
            }
            if(total>0){
                modelAndView.addObject("message","success");
            }else {
                modelAndView.addObject("message","failure");
            }
        }else {
            modelAndView.addObject("message","请先登录！");
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deleteFeedback.do")
    public Map deleteFeedback(Integer feedbackid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = feedbackService.deleteFeedback(feedbackid);
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

    @RequestMapping(value = "feedbackList.do")
    public ModelAndView feedbackList(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("user/feedbackInfo");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "feedbackInfoList.do")
    public DataGrid feedbackInfoList(HttpSession session) throws Exception{
        DataGrid<Feedback> dataGrid = new DataGrid<>();
        User user = (User) session.getAttribute("user");
        List<Feedback> data = feedbackService.findByfeedbackperson(user.getUserid());
        dataGrid.setData(data);
        return dataGrid;
    }
}
