package com.productstore.order.service;

import com.productstore.order.dto.InventoryDto;
import com.productstore.order.dto.OrderDto;
import com.productstore.order.dto.ProductDto;
import com.productstore.order.entity.Order;
import com.productstore.order.exceptions.OrderCannotCreatedException;
import com.productstore.order.exceptions.OrderNotFoundException;
import com.productstore.order.repo.OrderRepository;
import com.productstore.order.serviceproxy.InventoryServiceProxy;
import com.productstore.order.serviceproxy.ProductServiceProxy;
import com.productstore.order.utils.OrderConversion;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final InventoryServiceProxy inventoryServiceProxy;
    private final ProductServiceProxy productServiceProxy;
    private final KafkaTemplate<String,OrderDto> kafkaTemplate;

//    @Autowired
//    public OrderServiceImpl(OrderRepository orderRepository, InventoryServiceProxy inventoryServiceProxy, ProductServiceProxy productServiceProxy) {
//        this.orderRepository = orderRepository;
//        this.inventoryServiceProxy = inventoryServiceProxy;
//        this.productServiceProxy = productServiceProxy;
//    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        if(!checkInventory(orderDto)) throw new OrderCannotCreatedException("Order cannot be created due to insufficient inventory");
        Order order = OrderConversion.OrderDtoToOrder(orderDto);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Created");
        orderRepository.save(order);
        updateInventory(orderDto);
        OrderDto returningOrderDto = OrderConversion.OrderToOrderDto(order);
        returningOrderDto.setProductDto(getProduct(returningOrderDto.getProductId()));
        kafkaTemplate.send("order-topic",0,null, returningOrderDto);
        return returningOrderDto;
    }

    @Override
    public OrderDto updateOrder(Long orderId, OrderDto orderDto) {
        Order existingOrder = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        String status = existingOrder.getStatus();
        orderDto.setOrderId(orderId);
        Order order = OrderConversion.OrderDtoToOrder(orderDto);
        orderRepository.save(order);
        OrderDto returningOrderDto = OrderConversion.OrderToOrderDto(order);
        if(!Objects.equals(status, returningOrderDto.getStatus())){
            kafkaTemplate.send("order-topic",0,null, returningOrderDto);
        }
        return returningOrderDto;
    }

    @Override
    public OrderDto updateOrderStatus(Long orderId,OrderDto orderDto) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderDto.getOrderId()));
        String status = order.getStatus();
        order.setStatus(orderDto.getStatus());
        orderRepository.save(order);
        OrderDto returningOrderDto = OrderConversion.OrderToOrderDto(order);
        if(!Objects.equals(status, returningOrderDto.getStatus())){
            kafkaTemplate.send("order-topic",0,null, returningOrderDto);
        }
        return returningOrderDto;
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.delete(orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId)));
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        return OrderConversion.OrderToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        if (!orders.isEmpty()) {
            return orders.stream().map(OrderConversion::OrderToOrderDto).toList();
        }
        return List.of();
    }

    public boolean checkInventory(OrderDto orderDto) {
        InventoryDto inventoryDto = inventoryServiceProxy.getInventoryByProductId(orderDto.getProductId()).getBody();
        if(inventoryDto == null) throw new OrderNotFoundException("Product not found with id: " + orderDto.getProductId());
        return inventoryDto.getQuantity() >= orderDto.getQuantity();
    }

    public void updateInventory(OrderDto orderDto) {
        InventoryDto inventoryDto = inventoryServiceProxy.getInventoryByProductId(orderDto.getProductId()).getBody();
        if(inventoryDto == null) throw new OrderNotFoundException("Product not found with id: " + orderDto.getProductId());
        inventoryDto.setQuantity(inventoryDto.getQuantity() - orderDto.getQuantity());
        inventoryServiceProxy.updateInventory(inventoryDto.getId(), inventoryDto);
    }

    public ProductDto getProduct(String productId) {
        return productServiceProxy.getProduct(productId).getBody();
    }
}
