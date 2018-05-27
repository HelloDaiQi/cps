package com.daiqi.mapper;

import com.daiqi.entity.ProjectMumber;
import com.daiqi.entity.ProjectMumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMumberMapper {
    int countByExample(ProjectMumberExample example);

    int deleteByExample(ProjectMumberExample example);

    int deleteByPrimaryKey(Integer projectmumberid);

    int insert(ProjectMumber record);

    int insertSelective(ProjectMumber record);

    List<ProjectMumber> selectByExample(ProjectMumberExample example);

    ProjectMumber selectByPrimaryKey(Integer projectmumberid);

    int updateByExampleSelective(@Param("record") ProjectMumber record, @Param("example") ProjectMumberExample example);

    int updateByExample(@Param("record") ProjectMumber record, @Param("example") ProjectMumberExample example);

    int updateByPrimaryKeySelective(ProjectMumber record);

    int updateByPrimaryKey(ProjectMumber record);
}