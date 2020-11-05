package com.cardozo.infra.repository;

import com.cardozo.domain.Order;
import com.cardozo.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
@AllArgsConstructor
public class MongoDbOrderRepository implements OrderRepository {

    private final SpringDataMongoOrderRepository orderRepository;

    @Override
    public Optional<Order> findById(final String id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }
}