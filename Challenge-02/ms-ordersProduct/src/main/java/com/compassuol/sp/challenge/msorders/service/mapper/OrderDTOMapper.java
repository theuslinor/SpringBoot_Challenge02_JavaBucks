package com.compassuol.sp.challenge.msorders.service.mapper;

import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class OrderDTOMapper {
    public OrderDTO createOrderDTO(Order order){
        var orderDTOCreate = new OrderDTO();

        orderDTOCreate.setId(order.getId());
        orderDTOCreate.setProduct(order.getProduct());
        orderDTOCreate.setAddress(order.getAddress());
        orderDTOCreate.setPaymentMethod(order.getPaymentMethod());
        orderDTOCreate.setSubtotalValue(order.getSubtotalValue());
        orderDTOCreate.setDiscount(order.getDiscount());
        orderDTOCreate.setDate(LocalDateTime.now(ZoneOffset.UTC));
        orderDTOCreate.setStatus(order.getStatus());
        orderDTOCreate.setCancelReason(order.getCancelReason());
        orderDTOCreate.setCancelDate(order.getCancelDate());

        return orderDTOCreate;
    }
}
