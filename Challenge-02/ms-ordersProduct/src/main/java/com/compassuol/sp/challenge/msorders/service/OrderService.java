package com.compassuol.sp.challenge.msorders.service;

import com.compassuol.sp.challenge.msorders.client.ProductsFeign;
import com.compassuol.sp.challenge.msorders.client.ViaCepFeign;
<<<<<<< HEAD
import com.compassuol.sp.challenge.msorders.enums.Status;
import com.compassuol.sp.challenge.msorders.exception.OrderNotFoundException;
import com.compassuol.sp.challenge.msorders.exception.OrderUpdateNotAllowedException;
import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Order;
=======
import com.compassuol.sp.challenge.msorders.enems.PaymentMethod;
import com.compassuol.sp.challenge.msorders.enems.Status;
import com.compassuol.sp.challenge.msorders.exception.OrderNotFoundException;
import com.compassuol.sp.challenge.msorders.model.dto.OrderDTO;
import com.compassuol.sp.challenge.msorders.model.entity.Order;
import com.compassuol.sp.challenge.msorders.model.request.OrderRequest;
import com.compassuol.sp.challenge.msorders.model.request.ProductServiceRequest;
>>>>>>> postOrder
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
<<<<<<< HEAD
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
=======
>>>>>>> postOrder

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
<<<<<<< HEAD
=======

    private final AddressRepository addressRepository;

    private final ProductServiceRepository productServiceRepository;

>>>>>>> postOrder
    private final OrderMapper orderMapper;
    private final OrderDTOMapper orderDTOMapper;
    private final ViaCepFeign viaCepFeign;

<<<<<<< HEAD
    public AddressClientResponse searchCep(AddressClient addressClient) {
        return viaCepFeign.searchLocationByCep(addressClient.getCep());
=======
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
        if(addressClientViaCepResponse == null || productService.getId() == null){
            //throw new OrderNotFoundException();
//            ResponseEntity<OrderDTO> response = new ResponseEntity<>();
//            return ;
        }

        productServiceCreate.setId(orderRequest.getProductService().getId());
        productServiceCreate.setQuantity(orderRequest.getProductService().getQuantity());
        productServiceCreate.setName(productService.getName());
        productServiceCreate.setValue(productService.getValue());
        productServiceCreate.setDescription(productService.getDescription());


        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId(1L);
        orderResponse.setProducts(new ProductServiceRequest());
        orderResponse.getProducts().setId(productServiceCreate.getId());
        orderResponse.getProducts().setQuantity(productServiceCreate.getQuantity());

        orderResponse.setAddressClientResponse(addressClient);
        orderResponse.setPaymentMethod(orderRequest.getPayment_method());
        orderResponse.setSubtotalValue(productService.getValue());
        if(orderRequest.getPayment_method() == PaymentMethod.PIX){
            orderResponse.setDiscount(productService.getValue()*0.05);
        }else{
            orderResponse.setDiscount(0.0);
        }
        orderResponse.setTotalValue(productService.getValue() - orderResponse.getDiscount());
        orderResponse.setDate(LocalDateTime.now());
        orderResponse.setStatus(Status.CONFIRMED);


        AddressClient addressCreate = new AddressClient();

        addressCreate.setId(100L);
        addressCreate.setStreet(orderRequest.getAddressClientRequest().getStreet());
        addressCreate.setNumber(orderRequest.getAddressClientRequest().getNumber());
        addressCreate.setComplement(addressClientViaCepResponse.getComplemento());
        addressCreate.setCity(addressClientViaCepResponse.getLocalidade());
        addressCreate.setState(addressClientViaCepResponse.getUf());
        addressCreate.setZipCode(addressClientViaCepResponse.getCep());

        OrderDTO orderCreateDTO = new OrderDTO();

        orderCreateDTO.setId(1L);
        orderCreateDTO.setProductId(productService.getId());
        orderCreateDTO.setAddressId(100L);
        orderCreateDTO.setPaymentMethod(orderRequest.getPayment_method());
        orderCreateDTO.setSubtotalValue(orderResponse.getSubtotalValue());
        orderCreateDTO.setDiscount(orderResponse.getDiscount());
        orderCreateDTO.setTotalValue(orderResponse.getTotalValue());
        orderCreateDTO.setDate(orderResponse.getDate());
        orderCreateDTO.setStatus(Status.CONFIRMED);


        Order orderCreate = new Order();

        orderCreate.setId(addressCreate.getId());
        orderCreate.setProductId(orderCreateDTO.getId());
        orderCreate.setAddressId(100L);
        orderCreate.setPaymentMethod(orderRequest.getPayment_method());
        orderCreate.setSubtotalValue(orderResponse.getSubtotalValue());
        orderCreate.setDiscount(orderResponse.getDiscount());
        orderCreate.setTotalValue(orderResponse.getTotalValue());
        orderCreate.setDate(orderResponse.getDate());
        orderCreate.setStatus(Status.CONFIRMED);


        productServiceRepository.save(productServiceCreate);
        addressRepository.save(addressCreate);
        orderRepository.save(orderCreate);

        return orderResponse;
>>>>>>> postOrder
    }

    public OrderDTO getOrderById(Long id) {
        Order order= orderRepository.findById(id)
        .orElseThrow(() -> new OrderNotFoundException());
        return orderDTOMapper.createOrderDTO(order);
    }

    public List<OrderDTO> getAll(Status status) {
        List<Order> ordersList;
        List<OrderDTO> orderDTOList = new ArrayList<>();
        if(status!=null){
            ordersList = orderRepository.findAllByStatus(status);
            ordersList.sort(Comparator.comparing(Order::getDate).reversed());
        }else{
           ordersList = orderRepository.findAll();
           ordersList.sort(Comparator.comparing(Order::getDate).reversed());
        }
        for (Order order : ordersList) {
            OrderDTO orderDTO = orderDTOMapper.createOrderDTO(order);
            orderDTOList.add(orderDTO);
        }

        return orderDTOList;
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
}
