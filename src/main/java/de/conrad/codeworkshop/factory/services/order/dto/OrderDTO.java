package de.conrad.codeworkshop.factory.services.order.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    private final List<PositionDTO> positions;

    private final OrderConfirmationDTO orderConfirmation;

    @JsonCreator
    public OrderDTO(@JsonProperty("positions") List<PositionDTO> positions, @JsonProperty("orderConfirmation") OrderConfirmationDTO orderConfirmation) {
        this.positions = positions;
        this.orderConfirmation = orderConfirmation;
    }

    public List<PositionDTO> getPositions() {
        return positions;
    }

    public OrderConfirmationDTO getOrderConfirmation() {
        return orderConfirmation;
    }
}
