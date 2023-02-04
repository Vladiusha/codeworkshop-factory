package de.conrad.codeworkshop.factory.services.mapper.order;

import de.conrad.codeworkshop.factory.services.order.api.Order;
import de.conrad.codeworkshop.factory.services.order.api.OrderConfirmation;
import de.conrad.codeworkshop.factory.services.order.api.OrderNumber;
import de.conrad.codeworkshop.factory.services.order.api.Position;
import de.conrad.codeworkshop.factory.services.order.dto.OrderConfirmationDTO;
import de.conrad.codeworkshop.factory.services.order.dto.OrderDTO;
import de.conrad.codeworkshop.factory.services.order.dto.OrderNumberDTO;
import de.conrad.codeworkshop.factory.services.order.dto.PositionDTO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class OrderMapperImpl implements OrderMapper{
    @Override
    public Order orderDtoToOrder(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }

        Order order = new Order();

        order.setPositions(positionsDtoToPositions(orderDTO.getPositions()));
        order.setOrderConfirmation(orderConfirmationDtoToOrderConfirmation(orderDTO.getOrderConfirmation()));
        return order;
    }

    @Override
    public Position positionDtoToPosition(PositionDTO positionDTO) {
        if (positionDTO == null) {
            return null;
        }

        Position position = new Position();
        position.setProductId(positionDTO.getProductId());
        position.setQuantity(positionDTO.getQuantity());

        return position;
    }

    @Override
    public OrderNumber orderNumberDtoToOrderNumber(OrderNumberDTO orderNumberDTO) {
        if (orderNumberDTO == null || orderNumberDTO.getOrderNumberPlain() == null) {
            return null;
        }

        return new OrderNumber(new BigInteger(orderNumberDTO.getOrderNumberPlain().toString()));
    }

    @Override
    public OrderConfirmation orderConfirmationDtoToOrderConfirmation(OrderConfirmationDTO orderConfirmationDTO) {
        if (orderConfirmationDTO == null) {
            return null;
        }

        return new OrderConfirmation(orderNumberDtoToOrderNumber(orderConfirmationDTO.getOrderNumber()));
    }

    @Override
    public List<Position> positionsDtoToPositions(List<PositionDTO> positionsDTO) {
        if (positionsDTO == null) {
            return null;
        }

        List<Position> positions = new ArrayList<>();

        for (PositionDTO positionDTO : positionsDTO) {
            positions.add(positionDtoToPosition(positionDTO));
        }

        return positions;
    }
}
