package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.client.ProductsFeign;
import com.compassuol.sp.challenge.msorders.client.ViaCepFeign;
import com.compassuol.sp.challenge.msorders.enems.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enems.Status;
import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Order;
import com.compassuol.sp.challenge.msorders.model.request.OrderRequest;
import com.compassuol.sp.challenge.msorders.model.response.AddressClientResponse;
import com.compassuol.sp.challenge.msorders.model.response.AdressClienteViaCepResponse;
import com.compassuol.sp.challenge.msorders.model.response.OrderResponse;
import com.compassuol.sp.challenge.msorders.model.services.AddressClient;
import com.compassuol.sp.challenge.msorders.model.services.ProductService;
import com.compassuol.sp.challenge.msorders.repository.AddressRepository;
import com.compassuol.sp.challenge.msorders.repository.OrderRepository;
import com.compassuol.sp.challenge.msorders.repository.ProductServiceRepository;
import com.compassuol.sp.challenge.msorders.service.mapper.OrderDTOMapper;
import com.compassuol.sp.challenge.msorders.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final AddressRepository addressRepository;

    private final ProductServiceRepository productServiceRepository;

    private final OrderMapper orderMapper;

    private final OrderDTOMapper orderDTOMapper;

    private final ViaCepFeign viaCepFeign;

    private final ProductsFeign productsFeign;

    public AdressClienteViaCepResponse searchCep(AddressClient addressClient){
        return viaCepFeign.searchLocationByCep(addressClient.getZipCode());
    }

    public OrderDTO createOrder(OrderRequest orderRequest){

        AddressClientResponse addressClient = new AddressClientResponse();
        AdressClienteViaCepResponse addressClientViaCepResponse = viaCepFeign.searchLocationByCep(orderRequest.getAddressClientRequest().getZipCode());

        addressClient.setStreet(orderRequest.getAddressClientRequest().getStreet());
        addressClient.setNumber(orderRequest.getAddressClientRequest().getNumber());
        addressClient.setComplement(addressClientViaCepResponse.getComplemento());
        addressClient.setCity(addressClientViaCepResponse.getLocalidade());
        addressClient.setState(addressClientViaCepResponse.getUf());
        addressClient.setPostal_code(addressClientViaCepResponse.getCep());


        ProductService productServiceCreate = new ProductService();
        ProductService productService = productsFeign.getProductsById(orderRequest.getProductService().getId());

        productServiceCreate.setId(productService.getId());
        productServiceCreate.setQuantity(orderRequest.getProductService().getQuantity());
        productServiceCreate.setName(productService.getName());
        productServiceCreate.setValue(productService.getValue());
        productServiceCreate.setDescription(productService.getDescription());

        System.out.println(productServiceCreate);

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId(1L);
        orderResponse.setProducts(productService);

        orderResponse.setAddressClientResponse(addressClient);
        orderResponse.setPayment_method(orderRequest.getPayment_method());
        orderResponse.setSubtotal_value(productService.getValue());
        if(orderRequest.getPayment_method() == PaymentMethod.PIX){
            orderResponse.setDiscount(productService.getValue()*0.05);
        }else{
            orderResponse.setDiscount(0.0);
        }
        orderResponse.setTotal_value(productService.getValue() - orderResponse.getDiscount());
        orderResponse.setCreated_date(LocalDateTime.now());
        orderResponse.setStatus(Status.CONFIRMED);


        AddressClient addressCreate = new AddressClient();

        addressCreate.setStreet(orderRequest.getAddressClientRequest().getStreet());
        addressCreate.setNumber(orderRequest.getAddressClientRequest().getNumber());
        addressCreate.setComplement(addressClientViaCepResponse.getComplemento());
        addressCreate.setCity(addressClientViaCepResponse.getLocalidade());
        addressCreate.setState(addressClientViaCepResponse.getUf());
        addressCreate.setZipCode(addressClientViaCepResponse.getCep());

        OrderDTO orderCreateDTO = new OrderDTO();

        orderCreateDTO.setId(addressCreate.getId());
        orderCreateDTO.setProductId(productService.getId());
        orderCreateDTO.setAddressId(addressCreate);
        orderCreateDTO.setPaymentMethod(orderRequest.getPayment_method());
        orderCreateDTO.setSubtotalValue(orderResponse.getSubtotal_value());
        orderCreateDTO.setDiscount(orderResponse.getDiscount());
        orderCreateDTO.setTotalValue(orderResponse.getTotal_value());
        orderCreateDTO.setDate(orderResponse.getCreated_date());
        orderCreateDTO.setStatus(Status.CONFIRMED);


        Order orderCreate = new Order();

        orderCreate.setId(addressCreate.getId());
        orderCreate.setProductId(orderCreateDTO.getId());
        orderCreate.setAddressId(addressCreate);
        orderCreate.setPaymentMethod(orderRequest.getPayment_method());
        orderCreate.setSubtotalValue(orderResponse.getSubtotal_value());
        orderCreate.setDiscount(orderResponse.getDiscount());
        orderCreate.setTotalValue(orderResponse.getTotal_value());
        orderCreate.setDate(orderResponse.getCreated_date());
        orderCreate.setStatus(Status.CONFIRMED);


//        productServiceRepository.save(productServiceCreate);
//        addressRepository.save(addressCreate);
//        orderRepository.save(orderCreate);
//

        return orderCreateDTO;
    }
}
