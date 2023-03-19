package com.tgt.upcurve.OrderAPI.repository;

import com.tgt.upcurve.OrderAPI.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

}

