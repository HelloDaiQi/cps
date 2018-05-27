package com.daiqi.extend;

import com.daiqi.entity.Project;
import com.daiqi.entity.ProjectType;
import com.daiqi.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ProjectExtends extends Project {
    private UserExtends userExtends;

    private ProjectType type;

    private List<ProjectMumberExtends> projectMumberExtensList;

    private List<ApplicationProjectExtends> applicationProjectExtendsList;

    public UserExtends getUserExtends() {
        return userExtends;
    }

    public void setUserExtends(UserExtends userExtends) {
        this.userExtends = userExtends;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public List<ProjectMumberExtends> getProjectMumberExtensList() {
        return projectMumberExtensList;
    }

    public void setProjectMumberExtensList(List<ProjectMumberExtends> projectMumberExtensList) {
        this.projectMumberExtensList = projectMumberExtensList;
    }

    public List<ApplicationProjectExtends> getApplicationProjectExtendsList() {
        return applicationProjectExtendsList;
    }

    public void setApplicationProjectExtendsList(List<ApplicationProjectExtends> applicationProjectExtendsList) {
        this.applicationProjectExtendsList = applicationProjectExtendsList;
    }
}
