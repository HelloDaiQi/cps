package com.daiqi.mapper;

import com.daiqi.entity.Proficiency;
import com.daiqi.entity.ProficiencyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProficiencyMapper {
    int countByExample(ProficiencyExample example);

    int deleteByExample(ProficiencyExample example);

    int deleteByPrimaryKey(Integer proficiencyid);

    int insert(Proficiency record);

    int insertSelective(Proficiency record);

    List<Proficiency> selectByExample(ProficiencyExample example);

    Proficiency selectByPrimaryKey(Integer proficiencyid);

    int updateByExampleSelective(@Param("record") Proficiency record, @Param("example") ProficiencyExample example);

    int updateByExample(@Param("record") Proficiency record, @Param("example") ProficiencyExample example);

    int updateByPrimaryKeySelective(Proficiency record);

    int updateByPrimaryKey(Proficiency record);
}