package com.compassuol.sp.challenge.msfeedback.model.dto;

import com.compassuol.sp.challenge.msfeedback.enems.Status;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
