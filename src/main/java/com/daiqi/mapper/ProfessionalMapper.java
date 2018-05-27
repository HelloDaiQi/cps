package com.daiqi.mapper;

import com.daiqi.entity.Professional;
import com.daiqi.entity.ProfessionalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfessionalMapper {
    int countByExample(ProfessionalExample example);

    int deleteByExample(ProfessionalExample example);

    int deleteByPrimaryKey(Integer professionalid);

    int insert(Professional record);

    int insertSelective(Professional record);

    List<Professional> selectByExample(ProfessionalExample example);

    Professional selectByPrimaryKey(Integer professionalid);

    int updateByExampleSelective(@Param("record") Professional record, @Param("example") ProfessionalExample example);

    int updateByExample(@Param("record") Professional record, @Param("example") ProfessionalExample example);

    int updateByPrimaryKeySelective(Professional record);

    int updateByPrimaryKey(Professional record);
}