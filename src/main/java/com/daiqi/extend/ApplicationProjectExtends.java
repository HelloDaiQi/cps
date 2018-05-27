package com.daiqi.extend;

import com.daiqi.entity.ApplicationProject;
import com.daiqi.entity.Project;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ApplicationProjectExtends extends ApplicationProject {
    private UserExtends userExtends;

    private Project project;

    public UserExtends getUserExtends() {
        return userExtends;
    }

    public void setUserExtends(UserExtends userExtends) {
        this.userExtends = userExtends;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
