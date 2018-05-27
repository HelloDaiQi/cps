package com.daiqi.service;

import com.daiqi.entity.CertificationUser;
import com.daiqi.extend.CertificationUserExtends;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

public interface CertificationUserService {
    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    List<CertificationUser> findAll() throws Exception;

    CertificationUser findByCuserid(Integer cuserid) throws Exception;

    List<CertificationUserExtends> findNew() throws Exception;

    Integer saveCuser(CertificationUser cuser) throws Exception;

    Integer updateCuser(CertificationUser cuser)throws Exception;

    CertificationUserExtends findExtendsByCuserid(Integer cuserid) throws Exception;

    CertificationUser findByUserid(Integer userid) throws Exception;

    Integer deleteCuser(Integer cuserid) throws Exception;

    Integer countByCertificationtime(Date date) throws Exception;
}
