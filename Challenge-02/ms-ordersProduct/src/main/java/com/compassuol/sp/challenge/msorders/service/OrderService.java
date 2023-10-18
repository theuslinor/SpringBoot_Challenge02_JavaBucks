package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.client.ViaCepFeign;
import com.compassuol.sp.challenge.msorders.model.response.AddressClientResponse;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import com.compassuol.sp.challenge.msorders.repository.OrderRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.OrderDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final OrderDTOMapper orderDTOMapper;

    private final ViaCepFeign viaCepFeign;

    public AddressClientResponse searchCep(AddressClient addressClient){
        return viaCepFeign.searchLocationByCep(addressClient.getCep());
    }
}
