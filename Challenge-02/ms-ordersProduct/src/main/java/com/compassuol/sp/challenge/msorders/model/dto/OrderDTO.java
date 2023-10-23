package com.compassuol.sp.challenge.msorders.model.dto;

import com.compassuol.sp.challenge.msorders.enems.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enems.Status;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
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
