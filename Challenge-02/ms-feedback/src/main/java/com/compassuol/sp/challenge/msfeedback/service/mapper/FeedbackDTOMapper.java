package com.compassuol.sp.challenge.msfeedback.service.mapper;

import com.compassuol.sp.challenge.msfeedback.model.dto.FeedBackDTO;
import com.compassuol.sp.challenge.msfeedback.model.entity.FeedBack;
import org.springframework.stereotype.Component;

@Component
public class FeedbackDTOMapper {

    public FeedBackDTO createFeedBackDTO (FeedBack feedBack){
        var feedBackCreateDTO = new FeedBackDTO();

        feedBackCreateDTO.setId(feedBack.getId());
        feedBackCreateDTO.setScale(feedBack.getScale());
        feedBackCreateDTO.setComment(feedBack.getComment());
        feedBackCreateDTO.setOrderId(feedBack.getOrderId());

        return feedBackCreateDTO;
    }
}
