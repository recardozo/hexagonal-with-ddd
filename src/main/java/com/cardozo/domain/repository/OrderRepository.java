package com.cardozo.domain.repository;

import com.cardozo.domain.Order;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(String id);

    void save(Order order);
}
