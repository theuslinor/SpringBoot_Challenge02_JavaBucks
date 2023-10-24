package com.compassuol.sp.challenge.msfeedback.client;

import com.compassuol.sp.challenge.msfeedback.model.EntityAPI.OrderAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081/orders/", name = "MsFeedBack")
public interface OrderFeign {
    @GetMapping("/{id}")
    OrderAPI getOrdersById(@PathVariable Long id);
}
