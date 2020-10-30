package com.cardozo.domain.service;

import com.cardozo.domain.*;
import com.cardozo.domain.event.DomainEventNotifier;
import com.cardozo.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DomainOrderService implements OrderService {
    private final OrderRepository orderRepository;
    private final DomainEventNotifier notifier;

    public DomainOrderService(final OrderRepository orderRepository, DomainEventNotifier notifier) {
        this.orderRepository = orderRepository;
        this.notifier = notifier;
    }

    @Override
    public void createOrder(final Product product) {
        final Order order = new Order(UUID.randomUUID().toString(), product);
        notifier.notify(new OrderWasCreatedEvent(order));
    }

    @Override
    public void addProduct(final String id, final Product product) {
        final Order order = getOrder(id);
        order.addOrder(product);
        notifier.notify(new OrderWasUpdatedEvent(order));
    }

    @Override
    public void completeOrder(final String id) {
        final Order order = getOrder(id);
        order.complete();
        notifier.notify(new OrderWasCompletedEvent(order));
    }

    @Override
    public void deleteProduct(final String id, final String productId) {
        final Order order = getOrder(id);
        order.removeOrder(productId);
        notifier.notify(new OrderWasUpdatedEvent(order));
    }

    private Order getOrder(String id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Order with given id doesn't exist"));
    }
}
