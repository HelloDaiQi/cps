package com.daiqi.vo;

import java.util.ArrayList;
import java.util.List;

public class DataGrid<T> {
    private Long code=0L;
    private String msg="";
    private Long count = 0L;
    private List<T> data = new ArrayList<>();

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
