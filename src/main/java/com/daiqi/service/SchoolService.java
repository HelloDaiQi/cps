package com.daiqi.service;

import com.daiqi.entity.School;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SchoolService {

    List<School> findAll() throws Exception;

    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    School findBySchoolid(Integer schoolid) throws Exception;

    Integer saveSchool(School school) throws Exception;

    Integer updateSchool(School school) throws Exception;

    Integer deleteSchool(Integer schoolid) throws Exception;
}
