package com.cardozo.domain.service;

import com.cardozo.domain.Product;


public interface OrderService {
    void createOrder(Product product);

    void addProduct(String id, Product product);

    void completeOrder(String id);

    void deleteProduct(String id, String productId);
}