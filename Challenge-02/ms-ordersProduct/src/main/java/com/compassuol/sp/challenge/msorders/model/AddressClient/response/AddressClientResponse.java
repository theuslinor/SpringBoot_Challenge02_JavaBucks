package com.compassuol.sp.challenge.msorders.model.AddressClient.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddressClientResponse {

    private String logradouro;

    private String complemento;

    private String localidade;

    private String bairro;

    private String uf;

    private String cep;

}
