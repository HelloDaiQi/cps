package com.daiqi.entity;

import com.daiqi.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CertificationUser {
    private Integer cuserid;

    private Integer userid;

    private String realname;

    private String cardnumber;

    private String reason;

    private String opinion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date certificationtime;

    private String status;

    public Integer getCuserid() {
        return cuserid;
    }

    public void setCuserid(Integer cuserid) {
        this.cuserid = cuserid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber == null ? null : cardnumber.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public String getCertificationtime() {
        return certificationtime == null ? null : DateUtil.DatetoString(certificationtime);
        //return certificationtime;
    }

    public void setCertificationtime(Date certificationtime) {
        this.certificationtime = certificationtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}