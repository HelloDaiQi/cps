package com.daiqi.service.impl;

import com.daiqi.entity.School;
import com.daiqi.entity.SchoolExample;
import com.daiqi.mapper.SchoolMapper;
import com.daiqi.service.SchoolService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<School> findAll() throws Exception {
        SchoolExample schoolExample=new SchoolExample();
        List<School> schoolList = schoolMapper.selectByExample(schoolExample);
        return schoolList;
    }

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        SchoolExample example = new SchoolExample();
        SchoolExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andSchoolidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andSchoolnameLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<School> list = schoolMapper.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo<School> page = new PageInfo<School>(list);
        return page;
    }

    @Override
    public School findBySchoolid(Integer schoolid) throws Exception {
        return schoolMapper.selectByPrimaryKey(schoolid);
    }

    @Override
    public Integer saveSchool(School school) throws Exception {
        return schoolMapper.insertSelective(school);
    }

    @Override
    public Integer updateSchool(School school) throws Exception {
        return schoolMapper.updateByPrimaryKeySelective(school);
    }

    @Override
    public Integer deleteSchool(Integer schoolid) throws Exception {
        return schoolMapper.deleteByPrimaryKey(schoolid);
    }
}
