package com.daiqi.service.impl;

import com.daiqi.entity.UserRole;
import com.daiqi.entity.UserRoleExample;
import com.daiqi.mapper.UserRoleMapper;
import com.daiqi.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> findByUserid(Integer userid) throws Exception {
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        return userRoleMapper.selectByExample(example);
    }

    @Override
    public Integer saveUserRole(UserRole userRole) throws Exception {
        return userRoleMapper.insert(userRole);
    }

    @Override
    public Integer deleteUserRole(UserRole userRole) throws Exception {
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userRole.getUserid());
        criteria.andRoleidEqualTo(userRole.getRoleid());
        return userRoleMapper.deleteByExample(example);
    }
}
