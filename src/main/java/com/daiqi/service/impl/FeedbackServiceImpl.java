package com.daiqi.service.impl;

import com.daiqi.entity.Feedback;
import com.daiqi.entity.FeedbackExample;
import com.daiqi.mapper.FeedbackMapper;
import com.daiqi.service.FeedbackService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public PageInfo findByPage(DataSearch dataSearch) throws Exception {
        int pageNo = dataSearch.getPage() == null?1:dataSearch.getPage();
        int pageSize = dataSearch.getLimit() == null?10:dataSearch.getLimit();
        PageHelper.startPage(pageNo, pageSize);
        FeedbackExample example = new FeedbackExample();
        FeedbackExample.Criteria criteria = example.createCriteria();
        if(dataSearch.getCondition()!=null && dataSearch.getContent()!=null){
            if( dataSearch.getCondition().equals("1")){
                criteria.andFeedbackidEqualTo(Integer.parseInt(dataSearch.getContent()));
            }else if(dataSearch.getCondition().equals("2")){
                criteria.andContentLike("%"+dataSearch.getContent()+"%");
            }else if(dataSearch.getCondition().equals("3")){
                criteria.andTypeLike("%"+dataSearch.getContent()+"%");
            }
        }
        List<Feedback> list = feedbackMapper.selectByExample(example);
        PageInfo<Feedback> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Feedback findByFeedbackid(Integer feedbackid) throws Exception {
        return feedbackMapper.selectByPrimaryKey(feedbackid);
    }

    @Override
    public Integer saveFeedback(Feedback feedback) throws Exception {
        return feedbackMapper.insertSelective(feedback);
    }

    @Override
    public Integer updateFeedback(Feedback feedback) throws Exception {
        return feedbackMapper.updateByPrimaryKeySelective(feedback);
    }

    @Override
    public Integer deleteFeedback(Integer feedbackid) throws Exception {
        return feedbackMapper.deleteByPrimaryKey(feedbackid);
    }

    @Override
    public List<Feedback> findByfeedbackperson(Integer userid) throws Exception {
        FeedbackExample example = new FeedbackExample();
        FeedbackExample.Criteria criteria = example.createCriteria();
        criteria.andFeedbackpersonEqualTo(userid);
        return feedbackMapper.selectByExample(example);
    }

    @Override
    public Integer countByResult() throws Exception {
        FeedbackExample example = new FeedbackExample();
        FeedbackExample.Criteria criteria = example.createCriteria();
        criteria.andResultEqualTo("处理中");
        return feedbackMapper.countByExample(example);
    }
}
