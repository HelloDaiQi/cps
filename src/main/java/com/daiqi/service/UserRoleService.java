package com.daiqi.service;

import com.daiqi.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> findByUserid(Integer userid) throws Exception;

    Integer saveUserRole(UserRole userRole) throws Exception;

    Integer deleteUserRole(UserRole userRole) throws Exception;
}
