package com.compassuol.sp.challenge.msfeedback.model.EntityAPI;

import com.compassuol.sp.challenge.msfeedback.enums.StatusOrder;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAPI {

    private Long id;

    private Long productId;

    private Long addressId;

    private String paymentMethod;

    private Double subtotalValue;

    private Double discount;

    private Double totalValue;

    private LocalDateTime date;

    private String status;

    private String cancelReason;

    private String cancelDate;

}
