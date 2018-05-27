package com.daiqi.service.impl;

import com.daiqi.entity.ProjectType;
import com.daiqi.entity.ProjectTypeExample;
import com.daiqi.mapper.ProjectTypeMapper;
import com.daiqi.service.ProjectTypeService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

    @Autowired
    private ProjectTypeMapper projectTypeMapper;

    @Override
    public List<ProjectType> findAll() throws Exception {
        ProjectTypeExample example = new ProjectTypeExample();
        List<ProjectType> projectTypeList = projectTypeMapper.selectByExample(example);
        return projectTypeList;
    }

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        ProjectTypeExample example = new ProjectTypeExample();
        ProjectTypeExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andTypeidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andTypenameLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<ProjectType> list = projectTypeMapper.selectByExample(example);
        PageInfo<ProjectType> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ProjectType findByTypeid(Integer typeid) throws Exception {
        return projectTypeMapper.selectByPrimaryKey(typeid);
    }

    @Override
    public Integer saveProjectType(ProjectType projectType) {
        return projectTypeMapper.insert(projectType);
    }

    @Override
    public Integer updateProjectType(ProjectType projectType) {
        return projectTypeMapper.updateByPrimaryKeySelective(projectType);
    }

    @Override
    public Integer deleteProjectType(Integer typeid) {
        return projectTypeMapper.deleteByPrimaryKey(typeid);
    }
}
