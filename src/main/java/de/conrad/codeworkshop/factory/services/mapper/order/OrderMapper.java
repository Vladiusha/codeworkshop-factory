package de.conrad.codeworkshop.factory.services.mapper.order;

import de.conrad.codeworkshop.factory.services.order.api.Order;
import de.conrad.codeworkshop.factory.services.order.api.OrderConfirmation;
import de.conrad.codeworkshop.factory.services.order.api.OrderNumber;
import de.conrad.codeworkshop.factory.services.order.api.Position;
import de.conrad.codeworkshop.factory.services.order.dto.OrderConfirmationDTO;
import de.conrad.codeworkshop.factory.services.order.dto.OrderDTO;
import de.conrad.codeworkshop.factory.services.order.dto.OrderNumberDTO;
import de.conrad.codeworkshop.factory.services.order.dto.PositionDTO;

import java.util.List;

public interface OrderMapper {
    Order orderDtoToOrder(OrderDTO orderDTO);

    Position positionDtoToPosition(PositionDTO positionDTO);

    OrderNumber orderNumberDtoToOrderNumber(OrderNumberDTO orderNumberDTO);

    OrderConfirmation orderConfirmationDtoToOrderConfirmation(OrderConfirmationDTO orderConfirmationDTO);

    List<Position> positionsDtoToPositions(List<PositionDTO> positionsDTO);
}
