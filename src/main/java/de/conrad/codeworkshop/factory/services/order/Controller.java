package de.conrad.codeworkshop.factory.services.order;

import de.conrad.codeworkshop.factory.services.mapper.order.OrderMapper;
import de.conrad.codeworkshop.factory.services.mapper.order.OrderMapperImpl;
import de.conrad.codeworkshop.factory.services.order.api.Order;
import de.conrad.codeworkshop.factory.services.order.api.OrderConfirmation;
import de.conrad.codeworkshop.factory.services.order.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Andreas Hartmann
 */
@RestController("orderController")
@RequestMapping("/order")
public class Controller {

    private final Service factoryService;

    @Autowired
    public Controller(final Service service) {
        this.factoryService = service;
    }

    @PostMapping("/create")
    public OrderConfirmation createOrder(@RequestBody OrderDTO orderDTO) {
        OrderMapper orderMapper = new OrderMapperImpl();
        Order order = orderMapper.orderDtoToOrder(orderDTO);

        return factoryService.createOrder(order);
    }

    @DeleteMapping("/complete")
    public HttpStatus completeOrder() {
        HttpStatus status = HttpStatus.OK;

        factoryService.completeOrder();

        return status;
    }
}