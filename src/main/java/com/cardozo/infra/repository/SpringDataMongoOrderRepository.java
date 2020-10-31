package com.cardozo.infra.repository;

import com.cardozo.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoOrderRepository extends MongoRepository<Order, String> {
}