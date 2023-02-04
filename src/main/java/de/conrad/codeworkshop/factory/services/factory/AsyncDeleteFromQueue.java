package de.conrad.codeworkshop.factory.services.factory;

import de.conrad.codeworkshop.factory.services.order.api.Order;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service("asyncDeleteFromQueue")
public class AsyncDeleteFromQueue implements Runnable {
    private final de.conrad.codeworkshop.factory.services.factory.Service factoryService;

    private final de.conrad.codeworkshop.factory.services.notification.Service notificationService;

    @Autowired
    public AsyncDeleteFromQueue(Service factoryService, de.conrad.codeworkshop.factory.services.notification.Service notificationService) {
        this.factoryService = factoryService;
        this.notificationService = notificationService;
    }

    @Override
    public void run() {
        Order order = factoryService.removeFromQueue();

        try {
            Thread.sleep(5000);
            notificationService.notifyCustomer(order);
        } catch (final InterruptedException interruptedException) {
            System.err.println(interruptedException.getMessage());
        }
    }
}
