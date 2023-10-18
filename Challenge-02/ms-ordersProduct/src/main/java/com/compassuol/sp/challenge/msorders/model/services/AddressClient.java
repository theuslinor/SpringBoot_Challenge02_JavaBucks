package com.compassuol.sp.challenge.msorders.model.services;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "order_viaCep")
public class AddressClient {
    @Id
    @Column(name = "address_id")
    private Long id;

    private String street;

    private Long number;

    private String cep;
}
