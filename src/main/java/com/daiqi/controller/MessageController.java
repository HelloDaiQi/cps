package com.daiqi.controller;

import com.daiqi.entity.Message;
import com.daiqi.entity.User;
import com.daiqi.extend.MessageExtends;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.extend.UserExtends;
import com.daiqi.service.MessageService;
import com.daiqi.service.ProjectService;
import com.daiqi.service.UserService;
import com.daiqi.vo.DataGrid;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "message")
public class MessageController {

    @Resource
    private MessageService messageService;

    @Resource
    private UserService userService;

    @Resource
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = "listMessage.do")
    public DataGrid<Message> findMessage(DataSearch dataSearch) throws Exception{
        DataGrid<Message> dataGrid = new DataGrid<>();
        PageInfo pageInfo=messageService.findByPage(dataSearch);
        dataGrid.setData(pageInfo.getList());
        dataGrid.setCount(pageInfo.getTotal());
        return dataGrid;
    }

    @RequestMapping(value = "editMessage.do")
    public ModelAndView editMessage(Integer messageid) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Message message = messageService.findByMessageid(messageid);
        User sender = userService.findByUserid(message.getSender());
        User receiver = userService.findByUserid(message.getReceiver());
        modelAndView.addObject("message",message);
        modelAndView.addObject("sender",sender);
        modelAndView.addObject("receiver",receiver);
        modelAndView.setViewName("admin/form/messageForm");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "deleteMessage.do")
    public Map deleteMessage(Integer messageid){
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        try {
            total = messageService.deleteMessage(messageid);
        } catch (Exception e) {
            e.printStackTrace();
            res.put("json","false");
        }
        if(total>0){
            res.put("json","success");
        }else{
            res.put("json","false");
        }
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "deleteReceiveMessage.do")
    public Map deleteReceiveMessage(Integer messageid) throws Exception{
        Map<String,Object> res=new HashMap<>();
        Integer total=0;
        Message message = messageService.findByMessageid(messageid);
        message.setReceiver(-1);
        total = messageService.updateMessage(message);
        if(total>0){
            res.put("json","success");
        }else{
            res.put("json","false");
        }
        return res;
    }

    @RequestMapping(value = "receiveMessageList.do")
    public ModelAndView receiveMessageList(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        //User user = (User) session.getAttribute("user");
        //已经做了安全验证，不需要在进行判断了，用户信息不可能不存在的
//        if(user!=null){
//            modelAndView.setViewName("user/receiveMessage");
//        }else {
//            modelAndView.addObject("message","请先登录！");
//            modelAndView.setViewName("index");
//        }
        session.setAttribute("ReceiveMessageBage",0);
        modelAndView.setViewName("user/receiveMessage");
        return modelAndView;
    }

    @RequestMapping(value = "sendMessageList.do")
    public ModelAndView sendMessageList(HttpSession session) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            modelAndView.setViewName("user/sendMessage");
        }else {
            modelAndView.addObject("message","请先登录！");
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "messageList.do")
    public DataGrid messageList(String type,HttpSession session) throws Exception{
        User user = (User) session.getAttribute("user");
        DataGrid<MessageExtends> dataGrid = new DataGrid<>();
        if(user!=null){
            List<MessageExtends> data=null;
            if(type.equals("send")){
                data = messageService.findBySender(user.getUserid());
            }else if(type.equals("receive")){
                data = messageService.findByReceiver(user.getUserid());
            }
            dataGrid.setData(data);
        }
        return dataGrid;
    }

    @RequestMapping(value = "sendMessage.do")
    public ModelAndView sendMessage(Message message,Integer projectid,HttpSession session) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        User user = (User) session.getAttribute("user");
        if(user!=null){
            if(user.getStatus().equals("正常")){
                if(message.getMessageid()==null){
                    message.setSender(user.getUserid());
                    message.setSendtime(new Date());
                    total=messageService.saveMessage(message);
                }else {
                    total=messageService.updateMessage(message);
                }
                if(total>0){
                    modelAndView.addObject("message","success");
                }else {
                    modelAndView.addObject("message","failure");
                }
            }else {
                modelAndView.addObject("message","您的账号异常！");
            }
        }else {
            modelAndView.addObject("message","请先登录！");
        }
        if(projectid==null){
            UserExtends userExtends = userService.findExtendsByUserid(message.getReceiver());
            modelAndView.addObject("userExtends",userExtends);
            modelAndView.setViewName("userInfo");
        }else{
            ProjectExtends projectExtends = projectService.findExtendsByProjectid(projectid);
            modelAndView.addObject("projectExtends",projectExtends);
            modelAndView.setViewName("projectInfo");
        }
        return modelAndView;
    }

    @RequestMapping(value = "replyMessage.do")
    public ModelAndView replyMessage(Message message, HttpSession session) throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Integer total=0;
        User user = (User) session.getAttribute("user");
        if(user!=null){
            if(user.getStatus().equals("正常")){
                message.setSender(user.getUserid());
                message.setSendtime(new Date());
                total = messageService.saveMessage(message);
            }else {
                modelAndView.addObject("message","您的账号异常！");
            }
        }
        if(total>0){
            modelAndView.addObject("message","回复成功！");
        }else {
            modelAndView.addObject("message","回复失败！");
        }
        modelAndView.setViewName("user/receiveMessage");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "updateMessageStatus.do")
    public Map updateMessageStatus(Integer messageid) throws Exception{
        Message message = messageService.findByMessageid(messageid);
        message.setStatus("已读");
        messageService.updateMessage(message);
        return null;
    }
}
