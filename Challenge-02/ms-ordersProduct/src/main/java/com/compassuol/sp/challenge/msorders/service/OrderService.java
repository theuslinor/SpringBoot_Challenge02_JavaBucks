package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.client.ViaCepFeign;
import com.compassuol.sp.challenge.msorders.enems.Status;
import com.compassuol.sp.challenge.msorders.exception.OrderNotFoundException;
import com.compassuol.sp.challenge.msorders.exception.OrderUpdateNotAllowedException;
import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Order;
import com.compassuol.sp.challenge.msorders.model.response.AddressClientResponse;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import com.compassuol.sp.challenge.msorders.repository.OrderRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.OrderDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderDTOMapper orderDTOMapper;
    private final ViaCepFeign viaCepFeign;

    public AddressClientResponse searchCep(AddressClient addressClient) {
        return viaCepFeign.searchLocationByCep(addressClient.getCep());
    }

    public OrderDTO updateOrder(Long orderId, Status newStatus, String cancelReason) {
        Order existingOrder = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);

        if (existingOrder.getStatus() == Status.CONFIRMED) {
            existingOrder.setStatus(newStatus);
            existingOrder.setCancelDate(LocalDateTime.now(ZoneOffset.UTC).toString());
            existingOrder.setCancelReason(cancelReason);
        } else {
             throw new OrderUpdateNotAllowedException();
        }

        return orderDTOMapper.createOrderDTO(existingOrder);
    }


    public List<OrderDTO> getAll() {
        List<Order> orderList = orderRepository.findAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (Order order : orderList) {
            OrderDTO orderDTO = orderDTOMapper.createOrderDTO(order);
            orderDTOList.add(orderDTO);
        }

        return orderDTOList;
    }
}
