package com.compassuol.sp.challenge.msorders.client;

import com.compassuol.sp.challenge.msorders.model.response.AdressClienteViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/",name = "viacep")
public interface ViaCepFeign {
    @GetMapping("{cep}/json")
    AdressClienteViaCepResponse searchLocationByCep(@PathVariable("cep") String cep);
}
