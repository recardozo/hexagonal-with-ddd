package com.cardozo.domain.service;

import com.cardozo.domain.Product;

import java.util.UUID;


public interface OrderService {
    void createOrder(Product product);

    void addProduct(UUID id, Product product);

    void completeOrder(UUID id);

    void deleteProduct(UUID id, UUID productId);
}