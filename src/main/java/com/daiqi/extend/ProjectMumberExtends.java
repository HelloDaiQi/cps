package com.daiqi.extend;

import com.daiqi.entity.ProjectMumber;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ProjectMumberExtends extends ProjectMumber {
    private UserExtends userExtends;

    //@JsonBackReference//进行阻断，防止死循环
    private ProjectExtends projectExtends;


    public UserExtends getUserExtends() {
        return userExtends;
    }

    public void setUserExtends(UserExtends userExtends) {
        this.userExtends = userExtends;
    }

    public ProjectExtends getProjectExtends() {
        return projectExtends;
    }

    public void setProjectExtends(ProjectExtends projectExtends) {
        this.projectExtends = projectExtends;
    }
}
