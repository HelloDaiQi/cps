package com.daiqi.entity;

public class Proficiency {
    private Integer proficiencyid;

    private String proficiencyname;

    private String introduction;

    public Integer getProficiencyid() {
        return proficiencyid;
    }

    public void setProficiencyid(Integer proficiencyid) {
        this.proficiencyid = proficiencyid;
    }

    public String getProficiencyname() {
        return proficiencyname;
    }

    public void setProficiencyname(String proficiencyname) {
        this.proficiencyname = proficiencyname == null ? null : proficiencyname.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}