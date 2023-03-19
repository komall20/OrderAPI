package com.tgt.upcurve.OrderAPI.service;

import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.mapper.OrderMapper;
import com.tgt.upcurve.OrderAPI.repository.OrderItemsRepository;
import com.tgt.upcurve.OrderAPI.repository.OrderRepository;
import com.tgt.upcurve.OrderAPI.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;

    public OrderService(OrderRepository orderRepository, OrderItemsRepository orderItemsRepository) {
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemsRepository;
    }

    public OrderResponse fetchOrderByCustomerIdAndOrderId(Integer customerId, Integer orderId) {
        return OrderMapper.INSTANCE.toResponse(orderRepository.findOrderByCustomerIdAndOrderId(customerId, orderId));
    }

    public List<OrderResponse> fetchOrderByCustomerId(Integer customerId) {
        return OrderMapper.INSTANCE.toResponseList(orderRepository.findAllByCustomerId(customerId));
    }

    public OrderResponse saveOrder(Order order) {
        Order savedOrder = null;
        Order existingOrder = orderRepository.findOrderByCustomerIdAndOrderId(order.getCustomerId(), order.getOrderId());
        if(null == existingOrder){
            savedOrder = orderRepository.save(order);
        }
        return OrderMapper.INSTANCE.toResponse(savedOrder);
    }

    public void deleteOrder(Integer customerId, Integer orderId) {
        Order existingOrder = orderRepository.findOrderByCustomerIdAndOrderId(customerId, orderId);
        if(null != existingOrder){
            orderRepository.delete(existingOrder);
        }
    }

}
