package com.compassuol.sp.challenge.msorders.controller;


import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Order;
import com.compassuol.sp.challenge.msorders.model.request.OrderRequest;
import com.compassuol.sp.challenge.msorders.model.response.OrderResponse;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import com.compassuol.sp.challenge.msorders.service.OrderService;
import com.compassuol.sp.challenge.msorders.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    @GetMapping("/consulta")
    public ResponseEntity zipCodeQuery(@RequestBody AddressClient addressClient){
        return ResponseEntity.ok(orderService.searchCep(addressClient));
    }

    @GetMapping("/consultaOrder")
    public ResponseEntity Order(@RequestBody OrderDTO orderRequest){
        Order orderResponse = orderMapper.createOrderDTO(orderRequest);

        return null;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrdersById(@PathVariable Long id){
        OrderDTO orderDTO= orderService.getOrderById(id);
        return ResponseEntity.ok().body(orderDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrder(){
        List<OrderDTO> orderDTOS = orderService.getAll();
        return ResponseEntity.ok(orderDTOS);
    }
}
