package com.daiqi.test;

public class Test {
    public static void main(String[] args){
        String classFile = "com.jd".replaceAll(".","/") + "MyClass.class";
        System.out.println(classFile);
    }
}

