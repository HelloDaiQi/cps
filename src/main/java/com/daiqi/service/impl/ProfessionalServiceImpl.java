package com.daiqi.service.impl;

import com.daiqi.entity.Professional;
import com.daiqi.entity.ProfessionalExample;
import com.daiqi.mapper.ProfessionalMapper;
import com.daiqi.service.ProfessionalService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    @Autowired
    private ProfessionalMapper professionalMapper;

    @Override
    public List<Professional> findAll() throws Exception {
        ProfessionalExample professionalExample = new ProfessionalExample();
        List<Professional> professionalList = professionalMapper.selectByExample(professionalExample);
        return professionalList;
    }

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        ProfessionalExample example = new ProfessionalExample();
        ProfessionalExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andProfessionalidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andProfessionalnameLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<Professional> list = professionalMapper.selectByExample(example);
        PageInfo<Professional> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Professional findByProfessionalid(Integer professionalid) throws Exception {
        return professionalMapper.selectByPrimaryKey(professionalid);
    }

    @Override
    public Integer saveProfessional(Professional professional) throws Exception {
        return professionalMapper.insertSelective(professional);
    }

    @Override
    public Integer updateProfessional(Professional professional) throws Exception {
        return professionalMapper.updateByPrimaryKeySelective(professional);
    }

    @Override
    public Integer deleteProfessional(Integer professionalid) throws Exception {
        return professionalMapper.deleteByPrimaryKey(professionalid);
    }
}
