package com.compassuol.sp.challenge.msorders.entity;

import com.compassuol.sp.challenge.msorders.

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
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

    @ManyToOne
    @JoinColumn("id_product")
    private Product product;

    private String address;

    @NotBlank
    private String paymentMethod;

    @NotNull
    private Double subtotalValue;

    @NotNull
    private Double discount;

    @NotNull
    private Double totalValue;

    private LocalDate date = LocalDate.now();

    @NotBlank
    private String status;

    @NotBlank
    private String cancelReason;

    @NotBlank
    private String cancelDate;


}
