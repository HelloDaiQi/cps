package com.daiqi.extend;

import com.daiqi.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class UserExtends extends User implements Serializable {
    private School userSchool;

    private Grade userGrade;

    private Professional userProfessional;

    private Skill skillMajor;

    private Proficiency skillproficiencyMajor;

    private Skill skillMinor;

    private Proficiency skillproficiencyMinor;

    public School getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(School userSchool) {
        this.userSchool = userSchool;
    }

    public Grade getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(Grade userGrade) {
        this.userGrade = userGrade;
    }

    public Professional getUserProfessional() {
        return userProfessional;
    }

    public void setUserProfessional(Professional userProfessional) {
        this.userProfessional = userProfessional;
    }

    public Skill getSkillMajor() {
        return skillMajor;
    }

    public void setSkillMajor(Skill skillMajor) {
        this.skillMajor = skillMajor;
    }

    public Proficiency getSkillproficiencyMajor() {
        return skillproficiencyMajor;
    }

    public void setSkillproficiencyMajor(Proficiency skillproficiencyMajor) {
        this.skillproficiencyMajor = skillproficiencyMajor;
    }

    public Skill getSkillMinor() {
        return skillMinor;
    }

    public void setSkillMinor(Skill skillMinor) {
        this.skillMinor = skillMinor;
    }

    public Proficiency getSkillproficiencyMinor() {
        return skillproficiencyMinor;
    }

    public void setSkillproficiencyMinor(Proficiency skillproficiencyMinor) {
        this.skillproficiencyMinor = skillproficiencyMinor;
    }
}
