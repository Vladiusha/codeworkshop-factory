package de.conrad.codeworkshop.factory.services.order.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderNumberDTO {
    private final BigInteger orderNumberPlain;

    @JsonCreator
    public OrderNumberDTO(@JsonProperty("orderNumberPlain") BigInteger orderNumberPlain) {
        this.orderNumberPlain = orderNumberPlain;
    }

    public BigInteger getOrderNumberPlain() {
        return orderNumberPlain;
    }
}
