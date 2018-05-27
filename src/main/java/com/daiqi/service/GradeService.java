package com.daiqi.service;

import com.daiqi.entity.Grade;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GradeService {
    List<Grade> findAll() throws Exception;

    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    Grade findByGradeid(Integer gradeid) throws Exception;

    Integer saveGrade(Grade grade) throws Exception;

    Integer updateGrade(Grade grade) throws Exception;

    Integer deleteGrade(Integer gradeid) throws Exception;
}
