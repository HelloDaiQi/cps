package com.daiqi.service;

import com.daiqi.entity.User;
import com.daiqi.extend.UserExtends;
import com.daiqi.vo.DataSearch;
import com.daiqi.vo.IndexUserSearchData;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> findAll() throws Exception;

    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    User findByUserid(Integer userid) throws Exception;

    User findByEmailAndPassword(User user)  throws Exception;

    Integer saveUser(User user) throws Exception;

    Integer updateUser(User user) throws Exception;

    UserExtends findExtendsByUserid(Integer userid) throws Exception;

    List<UserExtends> findNew() throws Exception;

    PageInfo findExtendsByPage(IndexUserSearchData indexUserSearchData) throws Exception;

    Integer deleteUser(Integer userid) throws Exception;

    User findByEmail(String email) throws Exception;

    Set<String> getRoles(String email);

    Integer countByRegistertime(Date date) throws Exception;
}
