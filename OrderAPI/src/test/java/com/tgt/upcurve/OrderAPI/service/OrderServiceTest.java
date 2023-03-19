package com.tgt.upcurve.OrderAPI.service;

import com.tgt.upcurve.OrderAPI.OrderApiApplication;
import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.response.OrderResponse;
import com.tgt.upcurve.OrderAPI.utility.JsonUtility;
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
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    private static final String ORDER_JSON_FILE_PATH = "/orderData.json";

    @Test
    public void testFindByCustomerIdAndOrderId() throws Exception {
        Order order = JsonUtility.getOrderRequest(ORDER_JSON_FILE_PATH);
        OrderResponse savedOrder = orderService.saveOrder(order);
        OrderResponse existingOrder = orderService.fetchOrderByCustomerIdAndOrderId(20, 200);
        assert existingOrder != null;
    }

    @Test
    public void testFindOrderByCustomerId() throws Exception{
        Order order = JsonUtility.getOrderRequest(ORDER_JSON_FILE_PATH);
        OrderResponse savedOrder = orderService.saveOrder(order);
        List<OrderResponse> existingOrder = orderService.fetchOrderByCustomerId(20);
        assert existingOrder.size() > 0;
    }

    @Test
    public void testDeleteOrder() throws Exception{
        Order order = JsonUtility.getOrderRequest(ORDER_JSON_FILE_PATH);
        OrderResponse savedOrder = orderService.saveOrder(order);
        OrderResponse fetchedOrder = orderService.fetchOrderByCustomerIdAndOrderId(20,200);
        assert fetchedOrder != null;
        orderService.deleteOrder(20,200);
        OrderResponse fetchedOrder1 = orderService.fetchOrderByCustomerIdAndOrderId(20,200);
        assert fetchedOrder1 == null;
    }

}
