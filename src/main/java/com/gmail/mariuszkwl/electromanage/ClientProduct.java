package com.gmail.mariuszkwl.electromanage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class ClientProduct extends RepresentationModel<ClientProduct> {

    private final String client;
    private final String address;
    private final Integer amount;
    private final String note;

    @JsonCreator
    public ClientProduct(
            @JsonProperty("client") String client,
            @JsonProperty("address") String address,
            @JsonProperty("amount") Integer amount,
            @JsonProperty("note") String note
    ) {
        this.client = client;
        this.address = address;
        this.amount = amount;
        this.note = note;
    }

    public String getClient() {
        return client;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }
}
