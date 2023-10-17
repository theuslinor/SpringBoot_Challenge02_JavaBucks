package com.compassuol.sp.challenge.msorders.controller;

import com.compassuol.sp.challenge.msorders.model.AddressClient.AddressClient;
import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/consulta")
    public ResponseEntity zipCodeQuery(@RequestBody AddressClient addressClient){
        return ResponseEntity.ok(orderService.searchCep(addressClient));
    }

//    @PostMapping
//    public ResponseEntity createOrder(@RequestBody @Valid OrderDTO orderDTO){
//        orderService.searchCep(orderDTO);
//        return null;
//    }

}
