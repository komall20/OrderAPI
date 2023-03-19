package com.tgt.upcurve.OrderAPI.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("customer_id")
    private Integer customerId;

    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("store_id")
    private Integer storeId;

    @JsonProperty("order_status")
    private String orderStatus;

    @JsonProperty("order_amount")
    private Float orderAmount;

    @JsonProperty("payment_status")
    private String paymentStatus;

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("customer_mobile")
    private String customerMobile;

    @JsonProperty("order_items")
    private List<OrderItemsResponse> orderItems = new ArrayList<>();
}
