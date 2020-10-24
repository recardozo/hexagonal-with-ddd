package com.cardozo.infra.configuration;

import com.cardozo.DddHexagonalApplication;
import com.cardozo.domain.repository.OrderRepository;
import com.cardozo.domain.service.DomainOrderService;
import com.cardozo.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DddHexagonalApplication.class)
public class BeanConfiguration {

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }
}
