package com.tgt.upcurve.OrderAPI.entity;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonAlias("id")
    private Integer id;

    @Column(name = "order_id", insertable = false, updatable = false)
    @JsonAlias("orderId")
    private Integer orderId;

    @Column(name = "item_id")
    @JsonAlias("itemId")
    private Integer itemId;

    @Column(name="item_price")
    @JsonAlias("itemPrice")
    private Float itemPrice;

    @Column(name="item_description")
    @JsonAlias("itemDescription")
    private String itemDescription;

    @Column(name = "item_quantity")
    @JsonAlias("itemQuantity")
    private Integer itemQuantity;

}
