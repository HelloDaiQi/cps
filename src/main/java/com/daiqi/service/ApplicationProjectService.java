package com.daiqi.service;

import com.daiqi.entity.ApplicationProject;
import com.daiqi.extend.ApplicationProjectExtends;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ApplicationProjectService {
    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    ApplicationProject findByAprojectid(Integer aprojectid) throws Exception;

    Integer saveAproject(ApplicationProject aproject) throws Exception;

    Integer updateAproject(ApplicationProject aproject) throws Exception;

    List<ApplicationProjectExtends> findByApplicant(Integer userid) throws Exception;

    List<ApplicationProjectExtends> findExtendsByProjectid(Integer projectid) throws Exception;

    ApplicationProject findByApplicantAndProjectid(Integer applicant, Integer projectid) throws Exception;

    Integer deleteByAprojectid(Integer aprojectid) throws Exception;
}
