package com.compassuol.sp.challenge.msfeedback.controller;


import com.compassuol.sp.challenge.msfeedback.model.dto.FeedBackDTO;
import com.compassuol.sp.challenge.msfeedback.service.FeedBackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedbacks")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @PostMapping
    public ResponseEntity<FeedBackDTO> createFeedBack(@RequestBody @Valid FeedBackDTO feedBack){
        FeedBackDTO productResponseDTO = feedBackService.createFeedBack(feedBack);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDTO);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<FeedBackDTO> getFeedbacksById(@PathVariable Long id){
        FeedBackDTO feedBackDTO= feedBackService.getFeedbackById(id);
        return ResponseEntity.ok().body(feedBackDTO);
    }

    @GetMapping
    public ResponseEntity<List<FeedBackDTO>> getAll() {
        List<FeedBackDTO> products = feedBackService.getAll();
        return ResponseEntity.ok(products);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedBackDTO> updateFeedBack(@PathVariable Long id, @RequestBody FeedBackDTO feedBackDTO) {
        feedBackService.updateFeedBack(id, feedBackDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeedBackDTO> deleteFeedBack(@PathVariable Long id) {
        feedBackService.deleteFeedBack(id);
        return ResponseEntity.noContent().build();
    }
}
