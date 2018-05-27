package com.daiqi.mapper;

import com.daiqi.extend.UserExtends;

import java.util.List;
import java.util.Map;

public interface UserExtendsMapper {
    UserExtends selectByPrimaryKey(Integer userid) throws Exception;

    List<UserExtends> selectNew() throws Exception;

    List<UserExtends> selectByExample(Map<String, Object> map) throws Exception;
}
