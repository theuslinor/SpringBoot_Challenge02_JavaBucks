package com.compassuol.sp.challenge.msorders.service.mapper;

import com.compassuol.sp.challenge.msorders.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.entity.Order;

public class OrderDTOMapper {
    public OrderDTO createOrderDTO(Order order){
        var orderDTOCreate = new OrderDTO();

        orderDTOCreate.setId(order.getId());
        orderDTOCreate.setPaymentMethod(order.getPaymentMethod());
        orderDTOCreate.setSubtotalValue(order.getSubtotalValue());
        orderDTOCreate.setDiscount(order.getDiscount());
        orderDTOCreate.setTotalValue(order.getTotalValue());
        orderDTOCreate.setDate(order.getDate());
        orderDTOCreate.setStatus(order.getStatus());
        orderDTOCreate.setCancelReason(order.getCancelReason());
        orderDTOCreate.setCancelDate(order.getCancelDate());

        return orderDTOCreate;
    }
}
