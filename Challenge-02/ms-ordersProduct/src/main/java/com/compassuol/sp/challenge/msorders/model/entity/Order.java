package com.compassuol.sp.challenge.msorders.model.entity;

import com.compassuol.sp.challenge.msorders.model.productService.ProductService;
import com.compassuol.sp.challenge.msorders.model.AddressClient.AddressClient;
import com.compassuol.sp.challenge.msorders.model.AddressClient.response.services.ProductService;
import com.compassuol.sp.challenge.msorders.model.AddressClient.response.services.AddressClient;
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
    private String paymentMethod;

    @NotNull
    private Double subtotalValue;

    @NotNull
    private Double discount;

    @NotNull
    private LocalDateTime date;

    @NotBlank
    private String status;

    @NotBlank
    private String cancelReason;

    @NotBlank
    private String cancelDate;

}