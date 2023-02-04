package de.conrad.codeworkshop.factory.services.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PositionDTO {
    private final Integer productId;

    private final BigDecimal quantity;

    public PositionDTO(@JsonProperty("productId") Integer productId, @JsonProperty("quantity") BigDecimal quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
