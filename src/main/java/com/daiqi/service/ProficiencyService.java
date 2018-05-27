package com.daiqi.service;

import com.daiqi.entity.Proficiency;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProficiencyService {

    List<Proficiency> findAll() throws Exception;

    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    Proficiency findByProficiencyid(Integer proficiencyid) throws Exception;

    Integer saveProficiency(Proficiency proficiency) throws Exception;

    Integer updateProficiency(Proficiency proficiency) throws Exception;

    Integer deleteProficiency(Integer proficiencyid) throws Exception;
}
