package com.daiqi.mapper;

import com.daiqi.entity.ApplicationProject;
import com.daiqi.entity.ApplicationProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationProjectMapper {
    int countByExample(ApplicationProjectExample example);

    int deleteByExample(ApplicationProjectExample example);

    int deleteByPrimaryKey(Integer aprojectid);

    int insert(ApplicationProject record);

    int insertSelective(ApplicationProject record);

    List<ApplicationProject> selectByExample(ApplicationProjectExample example);

    ApplicationProject selectByPrimaryKey(Integer aprojectid);

    int updateByExampleSelective(@Param("record") ApplicationProject record, @Param("example") ApplicationProjectExample example);

    int updateByExample(@Param("record") ApplicationProject record, @Param("example") ApplicationProjectExample example);

    int updateByPrimaryKeySelective(ApplicationProject record);

    int updateByPrimaryKey(ApplicationProject record);
}