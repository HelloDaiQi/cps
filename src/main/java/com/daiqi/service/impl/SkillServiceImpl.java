package com.daiqi.service.impl;

import com.daiqi.entity.Skill;
import com.daiqi.entity.SkillExample;
import com.daiqi.mapper.SkillMapper;
import com.daiqi.service.SkillService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillMapper skillMapper;

    @Override
    public List<Skill> findAll() throws Exception {
        SkillExample skillExample = new SkillExample();
        List<Skill> skillList = skillMapper.selectByExample(skillExample);
        return skillList;
    }

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        SkillExample example = new SkillExample();
        SkillExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andSkillidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andSkillnameLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<Skill> list = skillMapper.selectByExample(example);
        PageInfo<Skill> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Skill findBySkillid(Integer skillid) throws Exception {
        return skillMapper.selectByPrimaryKey(skillid);
    }

    @Override
    public Integer saveSkill(Skill skill) throws Exception {
        return skillMapper.insertSelective(skill);
    }

    @Override
    public Integer updateSkill(Skill skill) throws Exception {
        return skillMapper.updateByPrimaryKeySelective(skill);
    }

    @Override
    public Integer deleteSkill(Integer skillid) throws Exception {
        return skillMapper.deleteByPrimaryKey(skillid);
    }
}
