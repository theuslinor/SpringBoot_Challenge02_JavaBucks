package com.compassuol.sp.challenge.msorders.service.mapper;

import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order createOrderDTO(OrderDTO orderDTO) {
        var orderDTOCreate = new Order();

        orderDTOCreate.setId(orderDTO.getId());
        orderDTOCreate.setProductId(orderDTO.getProductId());
        //orderDTOCreate.setAddressId(orderDTO.);
        orderDTOCreate.setPaymentMethod(orderDTO.getPaymentMethod());
        orderDTOCreate.setSubtotalValue(orderDTO.getSubtotalValue());
        orderDTOCreate.setDiscount(orderDTO.getDiscount());
        orderDTOCreate.setDate(orderDTO.getDate());
        orderDTOCreate.setStatus(orderDTO.getStatus());
        orderDTOCreate.setCancelReason(orderDTO.getCancelReason());
        orderDTOCreate.setCancelDate(orderDTO.getCancelDate());

        return orderDTOCreate;
    }
}
