package com.daiqi.util;

import com.daiqi.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PathUtil {

    public static String getPathByTime(){
        Date date = new Date();
        String path=new SimpleDateFormat("yyyy/MM/dd/").format(date);
        return path;
    }

    public static void main(String[] args){
        //System.out.println(PathUtil.getPathByTime());
        User user=new User();
        user.setStatus("正常");
        System.out.println(user.getStatus().equals("正常"));
    }
}
