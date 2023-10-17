package com.compassuol.sp.challenge.msorders.service.mapper;

import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class OrderMapper {
    public Order createOrderDTO(OrderDTO orderDTO) {
        var orderDTOCreate = new Order();

        orderDTOCreate.setId(orderDTO.getId());
        orderDTOCreate.setProduct(orderDTO.getProduct());
        orderDTOCreate.setAddress(orderDTO.getAddress());
        orderDTOCreate.setPaymentMethod(orderDTO.getPaymentMethod());
        orderDTOCreate.setSubtotalValue(orderDTO.getSubtotalValue());
        orderDTOCreate.setDiscount(orderDTO.getDiscount());
        orderDTOCreate.setDate(LocalDateTime.now(ZoneOffset.UTC));
        orderDTOCreate.setStatus(orderDTO.getStatus());
        orderDTOCreate.setCancelReason(orderDTO.getCancelReason());
        orderDTOCreate.setCancelDate(orderDTO.getCancelDate());

        return orderDTOCreate;
    }
}
