package com.cardozo.config;

import com.cardozo.domain.event.DomainEventListener;
import com.cardozo.domain.event.DomainEventType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class DomainEventConfiguration {

    @Bean
    public Map<DomainEventType, List<DomainEventListener>> listenersConfiguration(@Qualifier("orderCreatedListener") final DomainEventListener orderCreatedListener,
                                                                                  @Qualifier("orderUpdatedListener") final DomainEventListener orderUpdatedListener,
                                                                                  @Qualifier("orderCompletedListener") final DomainEventListener orderCompletedListener) {
        return Map.of(DomainEventType.ORDER_WAS_CREATED, List.of(orderCreatedListener),
                DomainEventType.ORDER_WAS_UPDATED, List.of(orderUpdatedListener),
                DomainEventType.ORDER_WAS_COMPLETED, List.of(orderCompletedListener)
        );
    }
}
