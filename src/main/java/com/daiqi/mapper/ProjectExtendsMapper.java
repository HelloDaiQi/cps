package com.daiqi.mapper;

import com.daiqi.extend.ProjectExtends;

import java.util.List;
import java.util.Map;

public interface ProjectExtendsMapper {
    ProjectExtends selectByPrimaryKey(Integer projectid) throws Exception;

    List<ProjectExtends> selectNew() throws Exception;

    List<ProjectExtends> selectByExample(Map<String, Object> map) throws Exception;

    List<ProjectExtends> selectByExample2(Map<String, Object> map) throws Exception;
}
