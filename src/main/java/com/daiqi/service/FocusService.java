package com.daiqi.service;

import com.daiqi.entity.Focus;
import com.daiqi.entity.User;

import java.util.List;

public interface FocusService {
    Boolean isFocused(Integer focuser, Integer befocuser) throws Exception;

    Integer deleteByFocuserAndBefocuser(Integer focuser, Integer befocuser) throws Exception;

    Integer saveFocus(Focus focus) throws Exception;

    List<Focus> findFocusByUserid(Integer focuser) throws Exception;

    Integer deleteByFocusid(Integer focusid) throws Exception;
}
