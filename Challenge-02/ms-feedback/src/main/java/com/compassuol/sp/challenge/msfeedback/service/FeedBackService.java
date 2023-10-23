package com.compassuol.sp.challenge.msfeedback.service;

import com.compassuol.sp.challenge.msfeedback.model.dto.FeedBackDTO;
import com.compassuol.sp.challenge.msfeedback.model.entity.FeedBack;
import com.compassuol.sp.challenge.msfeedback.repository.FeedBackRepository;
import com.compassuol.sp.challenge.msfeedback.service.mapper.FeedBackMapper;
import com.compassuol.sp.challenge.msfeedback.service.mapper.FeedbackDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedBackService {
    private final FeedBackRepository feedBackRepository;

    private final FeedBackMapper feedBackMapper;

    private final FeedbackDTOMapper feedbackDTOMapper;



    public FeedBackDTO createFeedBack(FeedBackDTO productRequestDTO){

        FeedBack product = feedBackMapper.createFeedBack(productRequestDTO);
        FeedBack productResponse = feedBackRepository.save(product);
        return feedbackDTOMapper.createFeedBackDTO(productResponse);
    }
}
