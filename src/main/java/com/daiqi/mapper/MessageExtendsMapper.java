package com.daiqi.mapper;

import com.daiqi.extend.MessageExtends;

import java.util.List;

public interface MessageExtendsMapper {
    List<MessageExtends> selectBySender(Integer userid);

    List<MessageExtends> selectByReceiver(Integer userid);
}
