package com.daiqi.service;

import com.daiqi.entity.Professional;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProfessionalService {

    List<Professional> findAll() throws Exception;

    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    Professional findByProfessionalid(Integer professionalid) throws Exception;

    Integer saveProfessional(Professional professional) throws Exception;

    Integer updateProfessional(Professional professional) throws Exception;

    Integer deleteProfessional(Integer professionalid) throws Exception;
}
