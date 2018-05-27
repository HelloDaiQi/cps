package com.daiqi.service.impl;

import com.daiqi.entity.Proficiency;
import com.daiqi.entity.ProficiencyExample;
import com.daiqi.mapper.ProficiencyMapper;
import com.daiqi.service.ProficiencyService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProficiencyServiceImpl implements ProficiencyService {

    @Autowired
    private ProficiencyMapper proficiencyMapper;

    @Override
    public List<Proficiency> findAll() throws Exception {
        ProficiencyExample example=new ProficiencyExample();
        List<Proficiency> skillProficiencyList=proficiencyMapper.selectByExample(example);
        return skillProficiencyList;
    }

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        ProficiencyExample example = new ProficiencyExample();
        ProficiencyExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andProficiencyidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andProficiencynameLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<Proficiency> list = proficiencyMapper.selectByExample(example);
        PageInfo<Proficiency> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Proficiency findByProficiencyid(Integer proficiencyid) throws Exception {
        return proficiencyMapper.selectByPrimaryKey(proficiencyid);
    }

    @Override
    public Integer saveProficiency(Proficiency proficiency) throws Exception {
        return proficiencyMapper.insertSelective(proficiency);
    }

    @Override
    public Integer updateProficiency(Proficiency proficiency) throws Exception {
        return proficiencyMapper.updateByPrimaryKeySelective(proficiency);
    }

    @Override
    public Integer deleteProficiency(Integer proficiencyid) throws Exception {
        return proficiencyMapper.deleteByPrimaryKey(proficiencyid);
    }
}
