package com.daiqi.service.impl;

import com.daiqi.entity.Message;
import com.daiqi.entity.MessageExample;
import com.daiqi.extend.MessageExtends;
import com.daiqi.mapper.MessageExtendsMapper;
import com.daiqi.mapper.MessageMapper;
import com.daiqi.service.MessageService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageExtendsMapper messageExtendsMapper;

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andMessageidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andContentLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<Message> list = messageMapper.selectByExample(example);
        PageInfo<Message> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Message findByMessageid(Integer messageid) throws Exception {
        return messageMapper.selectByPrimaryKey(messageid);
    }

    @Override
    public Integer deleteMessage(Integer messageid) throws Exception {
        return messageMapper.deleteByPrimaryKey(messageid);
    }

    @Override
    public Integer saveMessage(Message message) throws Exception {
        return messageMapper.insertSelective(message);
    }

    @Override
    public Integer updateMessage(Message message) throws Exception {
        return messageMapper.updateByPrimaryKey(message);
    }

    @Override
    public List<MessageExtends> findBySender(Integer userid) throws Exception {
        return messageExtendsMapper.selectBySender(userid);
    }

    @Override
    public List<MessageExtends> findByReceiver(Integer userid) throws Exception {
        return messageExtendsMapper.selectByReceiver(userid);
    }

    @Override
    public Integer countByReceiver(Integer userid) throws Exception {
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        criteria.andReceiverEqualTo(userid);
        criteria.andStatusEqualTo("未读");
        return messageMapper.countByExample(example);
    }
}
