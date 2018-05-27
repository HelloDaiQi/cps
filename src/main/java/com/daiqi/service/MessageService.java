package com.daiqi.service;

import com.daiqi.entity.Message;
import com.daiqi.extend.MessageExtends;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MessageService {
    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    Message findByMessageid(Integer messageid) throws Exception;

    Integer deleteMessage(Integer messageid) throws Exception;

    Integer saveMessage(Message message) throws Exception;

    Integer updateMessage(Message message) throws Exception;

    List<MessageExtends> findBySender(Integer userid) throws Exception;

    List<MessageExtends> findByReceiver(Integer userid) throws Exception;

    Integer countByReceiver(Integer userid) throws Exception;
}
