package com.daiqi.entity;

import com.daiqi.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Focus {
    private Integer focusid;

    private Integer focuser;

    private Integer befocuser;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date focustime;

    public Integer getFocusid() {
        return focusid;
    }

    public void setFocusid(Integer focusid) {
        this.focusid = focusid;
    }

    public Integer getFocuser() {
        return focuser;
    }

    public void setFocuser(Integer focuser) {
        this.focuser = focuser;
    }

    public Integer getBefocuser() {
        return befocuser;
    }

    public void setBefocuser(Integer befocuser) {
        this.befocuser = befocuser;
    }

    public String getFocustime() {
        return DateUtil.DatetoString(focustime);
    }

    public void setFocustime(Date focustime) {
        this.focustime = focustime;
    }
}