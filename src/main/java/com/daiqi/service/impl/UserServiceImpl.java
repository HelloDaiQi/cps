package com.daiqi.service.impl;

import com.daiqi.entity.*;
import com.daiqi.extend.UserExtends;
import com.daiqi.mapper.RoleMapper;
import com.daiqi.mapper.UserExtendsMapper;
import com.daiqi.mapper.UserMapper;
import com.daiqi.mapper.UserRoleMapper;
import com.daiqi.service.UserService;
import com.daiqi.vo.DataSearch;
import com.daiqi.vo.IndexUserSearchData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtendsMapper userExtendsMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<User> findAll() throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andStatusIsNotNull();
        return userMapper.selectByExample(example);
    }

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        //按条件查询
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andUseridEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andNicknameLike("%"+dataSearch.getContent()+"%");
            }else if(dataSearch.getCondition().equals("3")){
                criteria.andGenderEqualTo(dataSearch.getContent());
            }
        }
        criteria.andStatusIsNotNull();
        List<User> list = userMapper.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo<User> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public User findByUserid(Integer userid) throws Exception {
        User user = userMapper.selectByPrimaryKey(userid);
        return user;
    }

    @Override
    public User findByEmailAndPassword(User user) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(user.getEmail());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()==1){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public Integer saveUser(User user) throws Exception {
        return userMapper.insertSelective(user);
    }

    @Override
    public Integer updateUser(User user) throws Exception {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public UserExtends findExtendsByUserid(Integer userid) throws Exception {
        return userExtendsMapper.selectByPrimaryKey(userid);
    }

    @Override
    public List<UserExtends> findNew() throws Exception {
        return userExtendsMapper.selectNew();
    }

    @Override
    public PageInfo findExtendsByPage(IndexUserSearchData indexUserSearchData) throws Exception {
        int pageNo = indexUserSearchData.getPage() == null?1:indexUserSearchData.getPage();
        int pageSize = indexUserSearchData.getLimit() == null?12:indexUserSearchData.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        Map<String ,Object> map = new HashMap<>();
        map.put("school",indexUserSearchData.getSchool());
        map.put("skill",indexUserSearchData.getSkill());
        map.put("gender",indexUserSearchData.getGender());
        map.put("nickname",indexUserSearchData.getNickname());
        map.put("status","正常");
        List<UserExtends> userExtendsList = userExtendsMapper.selectByExample(map);
        //用PageInfo对结果进行包装
        PageInfo<UserExtends> page = new PageInfo<>(userExtendsList);
        return page;
    }

    @Override
    public Integer deleteUser(Integer userid) throws Exception {
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public User findByEmail(String email) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()==1){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public Set<String> getRoles(String email) {
        Set<String> set = new HashSet<>();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()==1){
            Integer userId = userList.get(0).getUserid();
            UserRoleExample example1 = new UserRoleExample();
            UserRoleExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andUseridEqualTo(userId);
            List<UserRole> userRoleList = userRoleMapper.selectByExample(example1);
            for(UserRole userRole:userRoleList){
                Role role = roleMapper.selectByPrimaryKey(userRole.getRoleid());
                set.add(role.getRolename());
            }
            return set;
        }
        return null;
    }

    @Override
    public Integer countByRegistertime(Date date) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andRegistertimeEqualTo(date);
        return userMapper.countByExample(example);
    }
}
