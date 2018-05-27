package com.daiqi.entity;

import com.daiqi.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Feedback {
    private Integer feedbackid;

    private Integer feedbackperson;

    private String content;

    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date feedbacktime;

    private String result;

    public Integer getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(Integer feedbackid) {
        this.feedbackid = feedbackid;
    }

    public Integer getFeedbackperson() {
        return feedbackperson;
    }

    public void setFeedbackperson(Integer feedbackperson) {
        this.feedbackperson = feedbackperson;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFeedbacktime() {
        return DateUtil.DatetoString(feedbacktime);
    }

    public void setFeedbacktime(Date feedbacktime) {
        this.feedbacktime = feedbacktime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}