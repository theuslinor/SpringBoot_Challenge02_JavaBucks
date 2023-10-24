package com.compassuol.sp.challenge.msfeedback.model.EntityAPI;

import com.compassuol.sp.challenge.msfeedback.enums.StatusOrder;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAPI {

    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusOrder status;

}
