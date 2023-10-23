package com.compassuol.sp.challenge.msfeedback.model.dto;

import com.compassuol.sp.challenge.msfeedback.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedBackDTO {
    private Long id;

    @NotNull
    private Status scale;

    @NotBlank
    private String comment;

    @NotBlank
    private Long order_id;

}
