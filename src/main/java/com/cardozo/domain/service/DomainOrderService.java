package com.cardozo.domain.service;

import com.cardozo.domain.Order;
import com.cardozo.domain.OrderWasCreatedEvent;
import com.cardozo.domain.Product;
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
        final Order order = new Order(UUID.randomUUID(), product);
        notifier.notify(new OrderWasCreatedEvent(order));
    }

    @Override
    public void addProduct(final UUID id, final Product product) {
        final Order order = getOrder(id);
        order.addOrder(product);

        orderRepository.save(order);
    }

    @Override
    public void completeOrder(final UUID id) {
        final Order order = getOrder(id);
        order.complete();

        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(final UUID id, final UUID productId) {
        final Order order = getOrder(id);
        order.removeOrder(productId);

        orderRepository.save(order);
    }

    private Order getOrder(UUID id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Order with given id doesn't exist"));
    }
}
