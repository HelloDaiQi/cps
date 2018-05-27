package com.daiqi.service;

import com.daiqi.entity.ProjectType;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProjectTypeService {
    List<ProjectType> findAll() throws Exception;

    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    ProjectType findByTypeid(Integer typeid) throws Exception;

    Integer saveProjectType(ProjectType projectType) throws Exception;

    Integer updateProjectType(ProjectType projectType) throws Exception;

    Integer deleteProjectType(Integer typeid) throws Exception;
}
