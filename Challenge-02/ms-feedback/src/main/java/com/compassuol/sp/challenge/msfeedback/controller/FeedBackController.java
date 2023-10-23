package com.compassuol.sp.challenge.msfeedback.controller;


import com.compassuol.sp.challenge.msfeedback.model.dto.FeedBackDTO;
import com.compassuol.sp.challenge.msfeedback.service.FeedBackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @PostMapping
    public ResponseEntity<FeedBackDTO> createFeedBack(@RequestBody @Valid FeedBackDTO feedBack){
        FeedBackDTO productResponseDTO = feedBackService.createFeedBack(feedBack);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDTO);
    }

}
