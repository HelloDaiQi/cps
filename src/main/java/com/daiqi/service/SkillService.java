package com.daiqi.service;

import com.daiqi.entity.Skill;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SkillService {
    List<Skill> findAll() throws Exception;

    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    Skill findBySkillid(Integer skillid) throws Exception;

    Integer saveSkill(Skill skill) throws Exception;

    Integer updateSkill(Skill skill) throws Exception;

    Integer deleteSkill(Integer skillid) throws Exception;
}
