package com.daiqi.service.impl;

import com.daiqi.entity.ApplicationProject;
import com.daiqi.entity.ApplicationProjectExample;
import com.daiqi.extend.ApplicationProjectExtends;
import com.daiqi.mapper.ApplicationProjectExtendsMapper;
import com.daiqi.mapper.ApplicationProjectMapper;
import com.daiqi.service.ApplicationProjectService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationProjectServiceImpl implements ApplicationProjectService {

    @Autowired
    private ApplicationProjectMapper applicationProjectMapper;

    @Autowired
    private ApplicationProjectExtendsMapper applicationProjectExtendsMapper;

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        ApplicationProjectExample example = new ApplicationProjectExample();
        ApplicationProjectExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andAprojectidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }
        }
        List<ApplicationProject> list = applicationProjectMapper.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo<ApplicationProject> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public ApplicationProject findByAprojectid(Integer aprojectid) throws Exception {
        return applicationProjectMapper.selectByPrimaryKey(aprojectid);
    }

    @Override
    public Integer saveAproject(ApplicationProject aproject) throws Exception {
        return applicationProjectMapper.insertSelective(aproject);
    }

    @Override
    public Integer updateAproject(ApplicationProject aproject) throws Exception {
        return applicationProjectMapper.updateByPrimaryKeySelective(aproject);
    }

    @Override
    public List<ApplicationProjectExtends> findByApplicant(Integer userid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("applicant",userid);
        return applicationProjectExtendsMapper.selectByExample(map);
    }

    @Override
    public List<ApplicationProjectExtends> findExtendsByProjectid(Integer projectid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("projectid",projectid);
        map.put("result","审核中");
        return applicationProjectExtendsMapper.selectByExample(map);
    }

    @Override
    public ApplicationProject findByApplicantAndProjectid(Integer applicant, Integer projectid) throws Exception {
        ApplicationProjectExample example = new ApplicationProjectExample();
        ApplicationProjectExample.Criteria criteria = example.createCriteria();
        criteria.andApplicantEqualTo(applicant);
        criteria.andProjectidEqualTo(projectid);
        List<ApplicationProject> applicationProjectList = applicationProjectMapper.selectByExample(example);
        if(applicationProjectList.size()==1){
            return applicationProjectList.get(0);
        }
        return null;
    }

    @Override
    public Integer deleteByAprojectid(Integer aprojectid) throws Exception {
        return applicationProjectMapper.deleteByPrimaryKey(aprojectid);
    }
}
