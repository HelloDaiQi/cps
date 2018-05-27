package com.daiqi.service.impl;

import com.daiqi.entity.Grade;
import com.daiqi.entity.GradeExample;
import com.daiqi.mapper.GradeMapper;
import com.daiqi.service.GradeService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> findAll() throws Exception {
        GradeExample example=new GradeExample();
        List<Grade> gradeList=gradeMapper.selectByExample(example);
        return gradeList;
    }

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        GradeExample example = new GradeExample();
        GradeExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andGradeidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andGradenameLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<Grade> list = gradeMapper.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo<Grade> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Grade findByGradeid(Integer gradeid) throws Exception {
        return gradeMapper.selectByPrimaryKey(gradeid);
    }

    @Override
    public Integer saveGrade(Grade grade) throws Exception {
        return gradeMapper.insertSelective(grade);
    }

    @Override
    public Integer updateGrade(Grade grade) throws Exception {
        return gradeMapper.updateByPrimaryKeySelective(grade);
    }

    @Override
    public Integer deleteGrade(Integer gradeid) throws Exception {
        return gradeMapper.deleteByPrimaryKey(gradeid);
    }
}
