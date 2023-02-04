package de.conrad.codeworkshop.factory.services.order.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderConfirmationDTO {
    private final OrderNumberDTO orderNumber;
    @JsonCreator
    public OrderConfirmationDTO(@JsonProperty("orderNumber") OrderNumberDTO orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderNumberDTO getOrderNumber() {
        return orderNumber;
    }
}
