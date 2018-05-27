package com.daiqi.service;

import com.daiqi.entity.Feedback;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface FeedbackService {
    PageInfo findByPage(DataSearch dataSearch) throws Exception;

    Feedback findByFeedbackid(Integer feedbackid) throws Exception;

    Integer saveFeedback(Feedback feedback) throws Exception;

    Integer updateFeedback(Feedback feedback) throws Exception;

    Integer deleteFeedback(Integer feedbackid) throws Exception;

    List<Feedback> findByfeedbackperson(Integer userid) throws Exception;

    Integer countByResult() throws Exception;
}
