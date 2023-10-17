package com.compassuol.sp.challenge.msorders.model.viacep;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "order_viaCep")
public class ViaCep {
    @Id
    @Column(name = "address_id")
    private Long id;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;


}
