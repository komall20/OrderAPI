package com.tgt.upcurve.OrderAPI.repository;

import com.tgt.upcurve.OrderAPI.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByOrderId(Integer orderId);

    List<Order> findAllByCustomerId(Integer customerId);

    Order findOrderByCustomerIdAndOrderId(Integer customerId, Integer orderId);
}
