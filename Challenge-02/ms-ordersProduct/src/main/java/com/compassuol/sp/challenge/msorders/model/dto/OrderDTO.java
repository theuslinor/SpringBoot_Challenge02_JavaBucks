package com.compassuol.sp.challenge.msorders.model.dto;

import com.compassuol.sp.challenge.msorders.enums.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enums.Status;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> postOrder

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
