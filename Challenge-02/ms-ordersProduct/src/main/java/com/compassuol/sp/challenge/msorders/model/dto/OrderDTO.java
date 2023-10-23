package com.compassuol.sp.challenge.msorders.model.dto;

import com.compassuol.sp.challenge.msorders.enums.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    private Long productId;

    private Long addressId;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Double subtotalValue;

    private Double discount;

    private Double totalValue;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String cancelReason;

    private String cancelDate;

    public OrderDTO(Long id){
        this.id = id;
    }

}
