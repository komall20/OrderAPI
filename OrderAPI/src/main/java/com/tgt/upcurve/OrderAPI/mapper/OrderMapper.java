package com.tgt.upcurve.OrderAPI.mapper;

import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.response.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderResponse toResponse(Order order);
    List<OrderResponse> toResponseList(List<Order> orderList);
}
