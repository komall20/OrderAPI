package com.tgt.upcurve.OrderAPI.repository;

import com.tgt.upcurve.OrderAPI.OrderApiApplication;
import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.utility.JsonUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OrderApiApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderRepositoryTests {

    @Autowired
    OrderRepository orderRepository;

    private static final String ORDER_JSON_FILE_PATH = "/orderData.json";

    @Test
    public void testFindByOrderId() throws Exception {
        Order order = JsonUtility.getOrderRequest(ORDER_JSON_FILE_PATH);
        Order savedOrder = orderRepository.save(order);
        Order fetchedOrder = orderRepository.findByOrderId(200);
        assert fetchedOrder != null;
    }

    @Test
    public void testFindByCustomerIdAndOrderId() throws Exception {
        Order order = JsonUtility.getOrderRequest(ORDER_JSON_FILE_PATH);
        Order savedOrder = orderRepository.save(order);
        Order fetchedOrder = orderRepository.findOrderByCustomerIdAndOrderId(20, 200);
        assert fetchedOrder != null;
    }

    @Test
    public void testSaveOrder() throws Exception {
        Order order = JsonUtility.getOrderRequest(ORDER_JSON_FILE_PATH);
        Order savedOrder = orderRepository.save(order);
        Assertions.assertNotNull(savedOrder.getId());
    }

    @Test
    public void testFetchOrderByCustomerId() throws Exception{
        Order order = JsonUtility.getOrderRequest(ORDER_JSON_FILE_PATH);
        Order savedOrder = orderRepository.save(order);
        List<Order> fetchedOrdersByCustomerId = orderRepository.findAllByCustomerId(order.getCustomerId());
        assert fetchedOrdersByCustomerId.size() > 0;
    }

    @Test
    public  void testDeleteOrder() throws Exception{
        Order order = JsonUtility.getOrderRequest(ORDER_JSON_FILE_PATH);
        Order savedOrder = orderRepository.save(order);
        Order fetchedOrder = orderRepository.findOrderByCustomerIdAndOrderId(20,200);
        assert fetchedOrder != null;
        orderRepository.delete(savedOrder);
        Order fetchedOrder1 = orderRepository.findOrderByCustomerIdAndOrderId(20,200);
        assert fetchedOrder1 == null;
    }




}
