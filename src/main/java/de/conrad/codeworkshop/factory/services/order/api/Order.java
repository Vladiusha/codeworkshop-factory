package de.conrad.codeworkshop.factory.services.order.api;

import java.util.List;

import static de.conrad.codeworkshop.factory.services.order.api.OrderStatus.*;

/**
 * @author Andreas Hartmann
 */
public class Order {
    private List<Position> positions;
    private OrderConfirmation orderConfirmation;
    private OrderStatus status = PENDING;

    public void validate() {
        if (positions != null && !positions.isEmpty() && status == PENDING && this.validateProductsIdAndQuantity()) {
            status = ACCEPTED;
        } else {
            status = DECLINED;
        }
    }
    public boolean validateProductsIdAndQuantity() {
        for (Position position : positions) {
            if (!position.validateProductId() || !position.validateQuantity()) {
                return false;
            }
        }
        return true;
    }

    public void setOrderConfirmation(final OrderConfirmation orderConfirmation) {
        this.orderConfirmation = orderConfirmation;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
