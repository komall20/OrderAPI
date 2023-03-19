package com.tgt.upcurve.OrderAPI.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("item_id")
    private Integer itemId;

    @JsonProperty("item_price")
    private Float itemPrice;

    @JsonProperty("item_description")
    private String itemDescription;

    @JsonProperty("item_quantity")
    private Integer itemQuantity;

}
