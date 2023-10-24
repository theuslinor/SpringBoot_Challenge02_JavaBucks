package com.compassuol.sp.challenge.msfeedback.service;

import com.compassuol.sp.challenge.msfeedback.client.OrderFeign;
import com.compassuol.sp.challenge.msfeedback.enums.StatusOrder;
import com.compassuol.sp.challenge.msfeedback.exception.BadRequestException;
import com.compassuol.sp.challenge.msfeedback.exception.FeedBackNotFoundException;
import com.compassuol.sp.challenge.msfeedback.model.EntityAPI.OrderAPI;
import com.compassuol.sp.challenge.msfeedback.model.dto.FeedBackDTO;
import com.compassuol.sp.challenge.msfeedback.model.entity.FeedBack;
import com.compassuol.sp.challenge.msfeedback.repository.FeedBackRepository;
import com.compassuol.sp.challenge.msfeedback.service.mapper.FeedBackMapper;
import com.compassuol.sp.challenge.msfeedback.service.mapper.FeedbackDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedBackService {
    private final FeedBackRepository feedBackRepository;

    private final FeedBackMapper feedBackMapper;

    private final FeedbackDTOMapper feedbackDTOMapper;

    private final OrderFeign orderFeign ;



    public FeedBackDTO createFeedBack(FeedBackDTO feedBackDTO){
        OrderAPI orderAPI = orderFeign.getOrdersById(feedBackDTO.getOrderId());

        if(orderAPI.getId() == null){
            throw new FeedBackNotFoundException();
        }
        if(orderAPI.getStatus() == "CANCELED"){
            throw new BadRequestException();
        }
        FeedBack feedBack = feedBackMapper.createFeedBack(feedBackDTO);
        FeedBack feedBackResponse = feedBackRepository.save(feedBack);
        return feedbackDTOMapper.createFeedBackDTO(feedBackResponse);
    }
    public FeedBackDTO getFeedbackById(Long id) {
        FeedBack feedBack= feedBackRepository.findById(id)
        .orElseThrow(() -> new FeedBackNotFoundException());
        return feedbackDTOMapper.createFeedBackDTO(feedBack);
    }

    public List<FeedBackDTO> getAll() {

        List<FeedBack> feedBackList = feedBackRepository.findAll();
        List<FeedBackDTO> feedBackDTOList = new ArrayList<>();

        for (FeedBack feedBack : feedBackList) {
            FeedBackDTO feedBackDTO = feedbackDTOMapper.createFeedBackDTO(feedBack);
            feedBackDTOList.add(feedBackDTO);
        }
        return feedBackDTOList;
    }

    public FeedBackDTO updateFeedBack(Long id, FeedBackDTO feedBackDTO) {
        FeedBack existingFeedBack = feedBackRepository.findById(id)
                .orElseThrow(() -> new FeedBackNotFoundException());

        existingFeedBack.setScale(feedBackDTO.getScale());
        existingFeedBack.setComment(feedBackDTO.getComment());
        feedBackRepository.save(existingFeedBack);

        return feedbackDTOMapper.createFeedBackDTO(existingFeedBack);
    }

    public void deleteFeedBack(Long id) {
        FeedBack existingFeedBack = feedBackRepository.findById(id)
                .orElseThrow(() -> new FeedBackNotFoundException());
        feedBackRepository.delete(existingFeedBack);
    }
}
