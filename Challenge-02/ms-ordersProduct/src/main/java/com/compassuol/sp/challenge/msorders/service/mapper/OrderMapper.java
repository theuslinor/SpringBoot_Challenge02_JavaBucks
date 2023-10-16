package com.compassuol.sp.challenge.msorders.service.mapper;

import com.compassuol.sp.challenge.msorders.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.entity.Order;

public class OrderMapper {
    public Order createOrderDTO(OrderDTO orderDTO) {
        var orderDTOCreate = new Order();

        orderDTOCreate.setId(orderDTO.getId());
        orderDTOCreate.setPaymentMethod(orderDTO.getPaymentMethod());
        orderDTOCreate.setSubtotalValue(orderDTO.getSubtotalValue());
        orderDTOCreate.setDiscount(orderDTO.getDiscount());
        orderDTOCreate.setTotalValue(orderDTO.getTotalValue());
        orderDTOCreate.setDate(orderDTO.getDate());
        orderDTOCreate.setStatus(orderDTO.getStatus());
        orderDTOCreate.setCancelReason(orderDTO.getCancelReason());
        orderDTOCreate.setCancelDate(orderDTO.getCancelDate());

        return orderDTOCreate;
    }
}
