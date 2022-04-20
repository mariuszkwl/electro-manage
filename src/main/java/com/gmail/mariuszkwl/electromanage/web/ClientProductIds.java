package com.gmail.mariuszkwl.electromanage.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientProductIds {

    private final Integer clientId;
    private final Integer productId;


    @JsonCreator
    public ClientProductIds(
            @JsonProperty("client_id") Integer clientId,
            @JsonProperty("product_id") Integer productId
    ) {
        this.clientId = clientId;
        this.productId = productId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getProductId() {
        return productId;
    }
}
