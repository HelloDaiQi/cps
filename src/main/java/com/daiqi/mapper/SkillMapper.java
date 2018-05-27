package com.daiqi.mapper;

import com.daiqi.entity.Skill;
import com.daiqi.entity.SkillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkillMapper {
    int countByExample(SkillExample example);

    int deleteByExample(SkillExample example);

    int deleteByPrimaryKey(Integer skillid);

    int insert(Skill record);

    int insertSelective(Skill record);

    List<Skill> selectByExample(SkillExample example);

    Skill selectByPrimaryKey(Integer skillid);

    int updateByExampleSelective(@Param("record") Skill record, @Param("example") SkillExample example);

    int updateByExample(@Param("record") Skill record, @Param("example") SkillExample example);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKey(Skill record);
}