package com.daiqi.service;

import com.daiqi.entity.Role;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {
    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    List<Role> findAll() throws Exception;

    Role findByRoleid(Integer roleid) throws Exception;

    Integer saveRole(Role role) throws Exception;

    Integer update(Role role) throws Exception;

    Integer deleteRole(Integer roleid) throws Exception;
}
