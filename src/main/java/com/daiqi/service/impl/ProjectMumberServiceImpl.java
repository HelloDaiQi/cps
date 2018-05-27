package com.daiqi.service.impl;

import com.daiqi.entity.ProjectMumber;
import com.daiqi.entity.ProjectMumberExample;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.extend.ProjectMumberExtends;
import com.daiqi.mapper.ProjectMumberExtendsMapper;
import com.daiqi.mapper.ProjectMumberMapper;
import com.daiqi.service.ProjectMumberService;
import com.daiqi.vo.IndexProjectSearchData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectMumberServiceImpl implements ProjectMumberService {

    @Autowired
    private ProjectMumberMapper projectMumberMapper;

    @Autowired
    private ProjectMumberExtendsMapper projectMumberExtendsMapper;

    @Override
    public List<ProjectMumber> findByProjectid(Integer projectid) throws Exception {
        ProjectMumberExample example = new ProjectMumberExample();
        ProjectMumberExample.Criteria criteria = example.createCriteria();
        criteria.andProjectidEqualTo(projectid);
        return projectMumberMapper.selectByExample(example);
    }

    @Override
    public List<ProjectMumberExtends> findExtendsByProjectid(Integer projectid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("projectid",projectid);
        return projectMumberExtendsMapper.selectByExample(map);
    }

    @Override
    public List<ProjectMumberExtends> findExtendsByUserid(Integer userid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("userid",userid);
        return projectMumberExtendsMapper.selectByExample(map);
    }

    @Override
    public PageInfo findExtendsByMumber(IndexProjectSearchData indexProjectSearchData) throws Exception {
        int pageNo = indexProjectSearchData.getPage() == null?1:indexProjectSearchData.getPage();
        int pageSize = indexProjectSearchData.getLimit() == null?10:indexProjectSearchData.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        Map<String,Object> map = new HashMap<>();
        map.put("userid",indexProjectSearchData.getMumber());
        List<ProjectMumberExtends> projectMumberExtendsList = projectMumberExtendsMapper.selectByExample(map);
//        if(indexProjectSearchData.getProjecttype()!=null){
//            for(ProjectMumberExtends projectMumberExtends : projectMumberExtendsList){
//                if(projectMumberExtends.getProjectExtends().getProjecttype() != indexProjectSearchData.getProjecttype()){
//                    projectMumberExtendsList.remove(projectMumberExtends);
//                }
//            }
//        }
//        if(indexProjectSearchData.getProjectname()!=null){
//            for(ProjectMumberExtends projectMumberExtends : projectMumberExtendsList){
//                if(!projectMumberExtends.getProjectExtends().getProjectname().contains(indexProjectSearchData.getProjectname())){
//                    projectMumberExtendsList.remove(projectMumberExtends);
//                }
//            }
//        }

        if(indexProjectSearchData.getProjecttype()!=null){
            for(int i=0;i<projectMumberExtendsList.size();i++){
                if(projectMumberExtendsList.get(i).getProjectExtends().getProjecttype() != indexProjectSearchData.getProjecttype()){
                    projectMumberExtendsList.remove(i);
                }
            }
        }
        if(indexProjectSearchData.getProjectname()!=null){
            for(int i=0;i<projectMumberExtendsList.size();i++){
                if(!projectMumberExtendsList.get(i).getProjectExtends().getProjectname().contains(indexProjectSearchData.getProjectname())){
                    projectMumberExtendsList.remove(i);
                }
            }
        }

        PageInfo<ProjectMumberExtends> page = new PageInfo<>(projectMumberExtendsList);
        return page;
    }

    @Override
    public Integer saveProjectMumber(ProjectMumber projectMumber) throws Exception {
        return projectMumberMapper.insert(projectMumber);
    }

    @Override
    public Integer countByProjectid(Integer projectid) throws Exception {
        ProjectMumberExample example = new ProjectMumberExample();
        ProjectMumberExample.Criteria criteria = example.createCriteria();
        criteria.andProjectidEqualTo(projectid);
        return projectMumberMapper.countByExample(example);
    }

    @Override
    public Integer countJoinNumber(Integer userid) throws Exception {
        ProjectMumberExample example = new ProjectMumberExample();
        ProjectMumberExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        return projectMumberMapper.countByExample(example);
    }
}
