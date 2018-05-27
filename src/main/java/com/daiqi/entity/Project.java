package com.daiqi.entity;

import com.daiqi.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Project {
    private Integer projectid;

    private Integer releaser;

    private String projectname;

    private String projectimage;

    private Integer projecttype;

    private String demand;

    private Integer numbers;

    private Integer progress;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releasetime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date stoptime;

    private String introduction;

    private String status;

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getReleaser() {
        return releaser;
    }

    public void setReleaser(Integer releaser) {
        this.releaser = releaser;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getProjectimage() {
        return projectimage;
    }

    public void setProjectimage(String projectimage) {
        this.projectimage = projectimage == null ? null : projectimage.trim();
    }

    public Integer getProjecttype() {
        return projecttype;
    }

    public void setProjecttype(Integer projecttype) {
        this.projecttype = projecttype;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand == null ? null : demand.trim();
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getReleasetime() {
        return releasetime==null?null:DateUtil.DatetoString(releasetime);
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getStoptime() {
        return stoptime==null?null:DateUtil.DatetoString(stoptime);
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}