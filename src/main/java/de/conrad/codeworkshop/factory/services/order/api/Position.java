package de.conrad.codeworkshop.factory.services.order.api;

import java.math.BigDecimal;

/**
 * @author Andreas Hartmann
 */
public class Position {
    private Integer productId;
    private BigDecimal quantity;

    public boolean validateProductId() {
        if (this.productId == null) {
            return false;
        }

        int digits = (int) Math.ceil(Math.log10(this.productId + 0.5));
        return digits >=6 && digits <= 9;
    }

    public boolean validateQuantity() {
        if (this.quantity == null) {
            return false;
        }

        boolean division = this.quantity.divide(BigDecimal.valueOf(10)).scale() == 0;
        boolean compare = this.quantity.compareTo(BigDecimal.valueOf(0)) > 0
                && this.quantity.compareTo(BigDecimal.valueOf(1)) < 0;
        boolean equal = this.quantity.equals(new BigDecimal("42.42"));
        return division || compare || equal;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
