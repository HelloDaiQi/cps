package com.daiqi.service.impl;

import com.daiqi.entity.Focus;
import com.daiqi.entity.FocusExample;
import com.daiqi.entity.User;
import com.daiqi.mapper.FocusMapper;
import com.daiqi.service.FocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FocusServiceImpl implements FocusService {

    @Autowired
    private FocusMapper focusMapper;

    @Override
    public Boolean isFocused(Integer focuser, Integer befocuser) throws Exception {
        FocusExample example = new FocusExample();
        FocusExample.Criteria criteria = example.createCriteria();
        criteria.andFocuserEqualTo(focuser);
        criteria.andBefocuserEqualTo(befocuser);
        List<Focus> focusList = focusMapper.selectByExample(example);
        Boolean isFocus = focusList.size()>=1?true:false;
        return isFocus;
    }

    @Override
    public Integer deleteByFocuserAndBefocuser(Integer focuser, Integer befocuser) {
        FocusExample example = new FocusExample();
        FocusExample.Criteria criteria = example.createCriteria();
        criteria.andFocuserEqualTo(focuser);
        criteria.andBefocuserEqualTo(befocuser);
        int delete = focusMapper.deleteByExample(example);
        return delete;
    }

    @Override
    public Integer saveFocus(Focus focus) throws Exception {
        return  focusMapper.insertSelective(focus);
    }

    @Override
    public List<Focus> findFocusByUserid(Integer focuser) throws Exception {
        FocusExample example = new FocusExample();
        FocusExample.Criteria criteria = example.createCriteria();
        criteria.andFocuserEqualTo(focuser);
        return focusMapper.selectByExample(example);
    }

    @Override
    public Integer deleteByFocusid(Integer focusid) throws Exception {
        return focusMapper.deleteByPrimaryKey(focusid);
    }
}
