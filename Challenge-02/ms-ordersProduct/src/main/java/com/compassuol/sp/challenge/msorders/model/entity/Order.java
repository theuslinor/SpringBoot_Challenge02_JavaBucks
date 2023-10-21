package com.compassuol.sp.challenge.msorders.model.entity;

import com.compassuol.sp.challenge.msorders.enems.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enems.Status;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "order_tb")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JoinColumn(name = "product_id")
    private Long productId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressClient addressId;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @NotNull
    private Double subtotalValue;

    @NotNull
    private Double discount;

    @NotNull
    private Double totalValue;

    @NotNull
    private LocalDateTime date;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Status status;

    private String cancelReason;

    private String cancelDate;

    public Order(Long id){
        this.id = id;
    }

}
