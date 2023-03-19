package com.tgt.upcurve.OrderAPI.entity;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonAlias("id")
    private Integer id;

    @Column(name = "customer_id")
    @JsonAlias("customerId")
    private Integer customerId;

    @Column(name="order_id")
    @JsonAlias("orderId")
    private Integer orderId;

    @Column(name="store_id")
    @JsonAlias("storeId")
    private Integer storeId;

    @Column(name="order_status")
    @JsonAlias("orderStatus")
    private String orderStatus;

    @Column(name="order_amount")
    @JsonAlias("orderAmount")
    private Float orderAmount;

    @Column(name="payment_status")
    @JsonAlias("paymentStatus")
    private String paymentStatus;

    @Column(name = "customer_email")
    @JsonAlias("customerEmail")
    private String customerEmail;

    @Column(name = "customer_mobile")
    @JsonAlias("customerMobile")
    private String customerMobile;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonProperty("order_items")
    @JsonAlias("orderItems")
    private List<OrderItems> orderItems = new ArrayList<>();
}
