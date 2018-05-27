package com.daiqi.mapper;

import com.daiqi.extend.ApplicationProjectExtends;

import java.util.List;
import java.util.Map;

public interface ApplicationProjectExtendsMapper {
    List<ApplicationProjectExtends> selectByExample(Map<String, Object> map) throws Exception;
}
