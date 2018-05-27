package com.daiqi.entity;

import java.util.Date;

public class User {
    private Integer userid;

    private String nickname;

    private String email;

    private String password;

    private String userimage;

    private String gender;

    private Integer school;

    private Integer grade;

    private Integer professional;

    private Integer experience;

    private Integer majorskill;

    private Integer majorskillproficiency;

    private Integer minorskill;

    private Integer minorskillproficiency;

    private String phonenumber;

    private String qqnumber;

    private Date registertime;

    private String introduction;

    private String status;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserimage() {
        return userimage;
    }

    public void setUserimage(String userimage) {
        this.userimage = userimage == null ? null : userimage.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getProfessional() {
        return professional;
    }

    public void setProfessional(Integer professional) {
        this.professional = professional;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getMajorskill() {
        return majorskill;
    }

    public void setMajorskill(Integer majorskill) {
        this.majorskill = majorskill;
    }

    public Integer getMajorskillproficiency() {
        return majorskillproficiency;
    }

    public void setMajorskillproficiency(Integer majorskillproficiency) {
        this.majorskillproficiency = majorskillproficiency;
    }

    public Integer getMinorskill() {
        return minorskill;
    }

    public void setMinorskill(Integer minorskill) {
        this.minorskill = minorskill;
    }

    public Integer getMinorskillproficiency() {
        return minorskillproficiency;
    }

    public void setMinorskillproficiency(Integer minorskillproficiency) {
        this.minorskillproficiency = minorskillproficiency;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getQqnumber() {
        return qqnumber;
    }

    public void setQqnumber(String qqnumber) {
        this.qqnumber = qqnumber == null ? null : qqnumber.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
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