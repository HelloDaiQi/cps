package com.daiqi.extend;

import com.daiqi.entity.ApplicationProject;

public class AprojectExtends extends ApplicationProject {
    private ProjectExtends projectExtends;

    public ProjectExtends getProjectExtends() {
        return projectExtends;
    }

    public void setProjectExtends(ProjectExtends projectExtends) {
        this.projectExtends = projectExtends;
    }
}
