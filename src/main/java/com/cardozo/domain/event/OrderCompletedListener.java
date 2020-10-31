package com.cardozo.domain.event;

import com.cardozo.domain.Order;
import com.cardozo.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class OrderCompletedListener implements DomainEventListener {
    private final OrderRepository orderRepository;

    @Override
    public void onEvent(final DomainEvent domainEvent) {
        Order order = (Order) domainEvent.getSource();
        orderRepository.save(order);
        log.info("Order was completed {}",order);
    }
}
