package com.tgt.upcurve.OrderAPI.mapper;

import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.entity.OrderItems;
import com.tgt.upcurve.OrderAPI.response.OrderItemsResponse;
import com.tgt.upcurve.OrderAPI.response.OrderResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-09T21:13:18+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.16.1 (Eclipse Adoptium)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId( order.getId() );
        orderResponse.setCustomerId( order.getCustomerId() );
        orderResponse.setOrderId( order.getOrderId() );
        orderResponse.setStoreId( order.getStoreId() );
        orderResponse.setOrderStatus( order.getOrderStatus() );
        orderResponse.setOrderAmount( order.getOrderAmount() );
        orderResponse.setPaymentStatus( order.getPaymentStatus() );
        orderResponse.setCustomerEmail( order.getCustomerEmail() );
        orderResponse.setCustomerMobile( order.getCustomerMobile() );
        orderResponse.setOrderItems( orderItemsListToOrderItemsResponseList( order.getOrderItems() ) );

        return orderResponse;
    }

    @Override
    public List<OrderResponse> toResponseList(List<Order> orderList) {
        if ( orderList == null ) {
            return null;
        }

        List<OrderResponse> list = new ArrayList<OrderResponse>( orderList.size() );
        for ( Order order : orderList ) {
            list.add( toResponse( order ) );
        }

        return list;
    }

    protected OrderItemsResponse orderItemsToOrderItemsResponse(OrderItems orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        OrderItemsResponse orderItemsResponse = new OrderItemsResponse();

        orderItemsResponse.setId( orderItems.getId() );
        orderItemsResponse.setOrderId( orderItems.getOrderId() );
        orderItemsResponse.setItemId( orderItems.getItemId() );
        orderItemsResponse.setItemPrice( orderItems.getItemPrice() );
        orderItemsResponse.setItemDescription( orderItems.getItemDescription() );
        orderItemsResponse.setItemQuantity( orderItems.getItemQuantity() );

        return orderItemsResponse;
    }

    protected List<OrderItemsResponse> orderItemsListToOrderItemsResponseList(List<OrderItems> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemsResponse> list1 = new ArrayList<OrderItemsResponse>( list.size() );
        for ( OrderItems orderItems : list ) {
            list1.add( orderItemsToOrderItemsResponse( orderItems ) );
        }

        return list1;
    }
}
