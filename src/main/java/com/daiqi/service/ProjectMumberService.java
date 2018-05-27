package com.daiqi.service;

import com.daiqi.entity.ProjectMumber;
import com.daiqi.extend.ProjectMumberExtends;
import com.daiqi.vo.IndexProjectSearchData;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProjectMumberService {
    List<ProjectMumber> findByProjectid(Integer projectid) throws Exception;

    List<ProjectMumberExtends> findExtendsByProjectid(Integer projectid) throws Exception;

    List<ProjectMumberExtends> findExtendsByUserid(Integer userid) throws Exception;

    PageInfo findExtendsByMumber(IndexProjectSearchData indexProjectSearchData) throws Exception;

    Integer saveProjectMumber(ProjectMumber projectMumber) throws Exception;

    Integer countByProjectid(Integer projectid) throws Exception;

    Integer countJoinNumber(Integer userid) throws Exception;
}
