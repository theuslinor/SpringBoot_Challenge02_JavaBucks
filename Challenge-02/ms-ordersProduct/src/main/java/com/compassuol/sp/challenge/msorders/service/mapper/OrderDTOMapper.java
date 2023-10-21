package com.compassuol.sp.challenge.msorders.service.mapper;

import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDTOMapper {
    public OrderDTO createOrderDTO(Order order){
        var orderDTOCreate = new OrderDTO();

        orderDTOCreate.setId(order.getId());
        orderDTOCreate.setProductService(order.getProductService());
        orderDTOCreate.setAddress(order.getAddress());
        orderDTOCreate.setPaymentMethod(order.getPaymentMethod());
        orderDTOCreate.setSubtotal_value(order.getSubtotal_value());
        orderDTOCreate.setDiscount(order.getDiscount());
        orderDTOCreate.setDate(order.getDate());
        orderDTOCreate.setStatus(order.getStatus());
        orderDTOCreate.setCancelReason(order.getCancelReason());
        orderDTOCreate.setCancelDate(order.getCancelDate());

        return orderDTOCreate;
    }
}
