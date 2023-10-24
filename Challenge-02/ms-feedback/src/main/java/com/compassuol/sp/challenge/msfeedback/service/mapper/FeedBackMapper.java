package com.compassuol.sp.challenge.msfeedback.service.mapper;

import com.compassuol.sp.challenge.msfeedback.model.dto.FeedBackDTO;
import com.compassuol.sp.challenge.msfeedback.model.entity.FeedBack;
import org.springframework.stereotype.Component;

@Component
public class FeedBackMapper {
    public FeedBack createFeedBack(FeedBackDTO feedBack) {
        var feedBackCreate = new FeedBack();

        feedBackCreate.setId(feedBack.getId());
        feedBackCreate.setScale(feedBack.getScale());
        feedBackCreate.setComment(feedBack.getComment());
        feedBackCreate.setOrderId(feedBack.getOrderId());

        return feedBackCreate;
    }
}
