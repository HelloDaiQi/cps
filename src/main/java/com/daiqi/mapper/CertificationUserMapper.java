package com.daiqi.mapper;

import com.daiqi.entity.CertificationUser;
import com.daiqi.entity.CertificationUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CertificationUserMapper {
    int countByExample(CertificationUserExample example);

    int deleteByExample(CertificationUserExample example);

    int deleteByPrimaryKey(Integer cuserid);

    int insert(CertificationUser record);

    int insertSelective(CertificationUser record);

    List<CertificationUser> selectByExample(CertificationUserExample example);

    CertificationUser selectByPrimaryKey(Integer cuserid);

    int updateByExampleSelective(@Param("record") CertificationUser record, @Param("example") CertificationUserExample example);

    int updateByExample(@Param("record") CertificationUser record, @Param("example") CertificationUserExample example);

    int updateByPrimaryKeySelective(CertificationUser record);

    int updateByPrimaryKey(CertificationUser record);
}