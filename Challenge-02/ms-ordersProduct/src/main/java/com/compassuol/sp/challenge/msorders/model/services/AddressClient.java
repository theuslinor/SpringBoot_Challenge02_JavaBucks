package com.compassuol.sp.challenge.msorders.model.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name = "order_viaCep")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String street;

    private Long number;

    private String complement;

    private String city;

    private String neighborhood;

    private String state;

    private String zipCode;

    public AddressClient(String zipCode){
        this.zipCode = zipCode;
    }
}
