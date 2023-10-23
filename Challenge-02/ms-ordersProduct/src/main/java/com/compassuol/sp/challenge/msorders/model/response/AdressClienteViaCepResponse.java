package com.compassuol.sp.challenge.msorders.model.response;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdressClienteViaCepResponse {
    private Long id;

    private String logradouro;

    private Long numero;

    private String complemento;

    private String localidade;

    private String bairro;

    private String uf;

    private String cep;
}
