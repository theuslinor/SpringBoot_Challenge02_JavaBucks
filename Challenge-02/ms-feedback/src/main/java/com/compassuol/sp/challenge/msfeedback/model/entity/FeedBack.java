package com.compassuol.sp.challenge.msfeedback.model.entity;

import com.compassuol.sp.challenge.msfeedback.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "feedback_tb")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Status scale;

    @NotBlank
    private String comment;

    @NotNull
    private Long order_id;

}
