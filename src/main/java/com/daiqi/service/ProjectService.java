package com.daiqi.service;

import com.daiqi.entity.Project;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.vo.DataSearch;
import com.daiqi.vo.IndexProjectSearchData;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    Project findByProjectid(Integer projectid) throws Exception;

    Integer saveProject(Project project) throws Exception;

    Integer updateProject(Project project) throws Exception;

    Integer deleteProject(Integer projectid) throws Exception;

    List<ProjectExtends> findNew() throws Exception;

    ProjectExtends findExtendsByProjectid(Integer projectid) throws Exception;

    PageInfo findExtendsByPage(IndexProjectSearchData indexProjectSearchData) throws Exception;

    PageInfo findAllExtendsByPage(IndexProjectSearchData indexProjectSearchData) throws Exception;

    List<ProjectExtends> findExtendsByReleaser(Integer userid) throws Exception;

    List<ProjectExtends> findHistoryExtendsByReleaser(Integer userid) throws Exception;

    Integer countReleaseNumber(Integer userid) throws Exception;

    Integer countByReleasetime(Date date) throws Exception;
}
