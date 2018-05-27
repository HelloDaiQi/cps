package com.daiqi.entity;

import com.daiqi.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ApplicationProject {
    private Integer aprojectid;

    private Integer projectid;

    private Integer applicant;

    private String reason;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applicationtime;

    private String result;

    public Integer getAprojectid() {
        return aprojectid;
    }

    public void setAprojectid(Integer aprojectid) {
        this.aprojectid = aprojectid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getApplicant() {
        return applicant;
    }

    public void setApplicant(Integer applicant) {
        this.applicant = applicant;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getApplicationtime() {
        return DateUtil.DatetoString(applicationtime);
    }

    public void setApplicationtime(Date applicationtime) {
        this.applicationtime = applicationtime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}