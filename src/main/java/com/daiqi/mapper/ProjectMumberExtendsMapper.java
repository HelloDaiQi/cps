package com.daiqi.mapper;

import com.daiqi.extend.ProjectMumberExtends;

import java.util.List;
import java.util.Map;

public interface ProjectMumberExtendsMapper {
    List<ProjectMumberExtends> selectByExample(Map<String, Object> map) throws Exception;
}
