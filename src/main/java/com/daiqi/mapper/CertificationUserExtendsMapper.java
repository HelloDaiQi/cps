package com.daiqi.mapper;

import com.daiqi.extend.CertificationUserExtends;

import java.util.List;

public interface CertificationUserExtendsMapper {
    CertificationUserExtends selectByPrimaryKey(Integer cuserid) throws Exception;

    List<CertificationUserExtends> selectNew() throws Exception;
}
