package com.compassuol.sp.challenge.msorders.model.entity;

import com.compassuol.sp.challenge.msorders.enems.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enems.Status;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import com.compassuol.sp.challenge.msorders.model.services.ProductService;
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
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductService productService;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressClient address;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @NotNull
    private Double subtotal_value;

    @NotNull
    private Double discount;

    @NotNull
    private Double total_value;

    @NotNull
    private LocalDateTime date;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotBlank
    private String cancelReason;

    @NotBlank
    private String cancelDate;

}
