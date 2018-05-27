package com.daiqi.service.impl;

import com.daiqi.entity.Role;
import com.daiqi.entity.RoleExample;
import com.daiqi.mapper.RoleMapper;
import com.daiqi.service.RoleService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        RoleExample example=new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        //按条件查询
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andRoleidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andRolenameLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<Role> list = roleMapper.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo<Role> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public List<Role> findAll() throws Exception {
        RoleExample example = new RoleExample();
        return roleMapper.selectByExample(example);
    }

    @Override
    public Role findByRoleid(Integer roleid) throws Exception {
        return roleMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public Integer saveRole(Role role) throws Exception {
        return roleMapper.insertSelective(role);
    }

    @Override
    public Integer update(Role role) throws Exception {
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public Integer deleteRole(Integer roleid) throws Exception {
        return roleMapper.deleteByPrimaryKey(roleid);
    }
}
