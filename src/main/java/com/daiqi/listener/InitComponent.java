package com.daiqi.listener;

import com.daiqi.entity.CertificationUser;
import com.daiqi.entity.Project;
import com.daiqi.extend.CertificationUserExtends;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.extend.UserExtends;
import com.daiqi.service.CertificationUserService;
import com.daiqi.service.ProjectService;
import com.daiqi.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.*;

@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //在这里写代码
        ServletContext application = sce.getServletContext();
        UserService userService = (UserService) applicationContext.getBean("userService");
        ProjectService projectService = (ProjectService) applicationContext.getBean("projectService");
        List<UserExtends> userExtendsList = new ArrayList<>();
        List<ProjectExtends> projectExtendsList = new ArrayList<>();
        try {
            userExtendsList = userService.findNew();
            projectExtendsList = projectService.findNew();
        } catch (Exception e) {
            e.printStackTrace();
        }
        application.setAttribute("userExtendsList",userExtendsList);
        application.setAttribute("projectExtendsList",projectExtendsList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        application.removeAttribute("userExtendsList");
        application.removeAttribute("projectExtendsList");
    }
}
