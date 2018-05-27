package com.daiqi.service.impl;

import com.daiqi.entity.Project;
import com.daiqi.entity.ProjectExample;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.mapper.ProjectExtendsMapper;
import com.daiqi.mapper.ProjectMapper;
import com.daiqi.service.ProjectService;
import com.daiqi.vo.DataSearch;
import com.daiqi.vo.IndexProjectSearchData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectExtendsMapper projectExtendsMapper;

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andProjectidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andProjectnameLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<Project> list = projectMapper.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo<Project> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Project findByProjectid(Integer projectid) throws Exception {
        Project project = projectMapper.selectByPrimaryKey(projectid);
        return project;
    }

    @Override
    public Integer saveProject(Project project) throws Exception {
        return projectMapper.insertSelective(project);
    }

    @Override
    public Integer updateProject(Project project) throws Exception {
        return projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public Integer deleteProject(Integer projectid) throws Exception {
        return projectMapper.deleteByPrimaryKey(projectid);
    }

    @Override
    public List<ProjectExtends> findNew() throws Exception {
        return projectExtendsMapper.selectNew();
    }

    @Override
    public ProjectExtends findExtendsByProjectid(Integer projectid) throws Exception {
        return projectExtendsMapper.selectByPrimaryKey(projectid);
    }

    @Override
    public PageInfo findExtendsByPage(IndexProjectSearchData indexProjectSearchData) throws Exception {
        int pageNo = indexProjectSearchData.getPage() == null?1:indexProjectSearchData.getPage();
        int pageSize = indexProjectSearchData.getLimit() == null?10:indexProjectSearchData.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        Map<String,Object> map = new HashMap<>();
        map.put("releaser",indexProjectSearchData.getReleaser());
        map.put("projecttype",indexProjectSearchData.getProjecttype());
        map.put("projectname",indexProjectSearchData.getProjectname());
        map.put("status","正常");
        if(indexProjectSearchData.getProgress()==null){
            map.put("notProgress",100);
        }else {
            map.put("progress",indexProjectSearchData.getProgress());
        }
        List<ProjectExtends> projectExtendsList = projectExtendsMapper.selectByExample(map);
        PageInfo<ProjectExtends> page = new PageInfo<>(projectExtendsList);
        return page;
    }

    @Override
    public PageInfo findAllExtendsByPage(IndexProjectSearchData indexProjectSearchData) throws Exception {
        int pageNo = indexProjectSearchData.getPage() == null?1:indexProjectSearchData.getPage();
        int pageSize = indexProjectSearchData.getLimit() == null?10:indexProjectSearchData.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        Map<String,Object> map = new HashMap<>();
        map.put("releaser",indexProjectSearchData.getReleaser());
        map.put("projecttype",indexProjectSearchData.getProjecttype());
        map.put("projectname",indexProjectSearchData.getProjectname());
        List<ProjectExtends> projectExtendsList = projectExtendsMapper.selectByExample2(map);
        PageInfo<ProjectExtends> page = new PageInfo<>(projectExtendsList);
        return page;
    }

    @Override
    public List<ProjectExtends> findExtendsByReleaser(Integer userid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("releaser",userid);
        return projectExtendsMapper.selectByExample(map);
    }

    @Override
    public List<ProjectExtends> findHistoryExtendsByReleaser(Integer userid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("releaser",userid);
        map.put("progress",100);
        return projectExtendsMapper.selectByExample(map);
    }

    @Override
    public Integer countReleaseNumber(Integer userid) throws Exception {
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andReleaserEqualTo(userid);
        return projectMapper.countByExample(example);
    }

    @Override
    public Integer countByReleasetime(Date date) throws Exception {
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();
        criteria.andReleasetimeEqualTo(date);
        return projectMapper.countByExample(example);
    }
}
