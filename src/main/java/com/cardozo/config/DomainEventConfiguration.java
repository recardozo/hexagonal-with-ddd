package com.cardozo.config;

import com.cardozo.domain.event.DomainEventListener;
import com.cardozo.domain.event.DomainEventType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DomainEventConfiguration {

    public Map<DomainEventType, List<DomainEventListener>> listenersConfiguration(@Qualifier("orderCreatedListener")final DomainEventListener orderCreatedListener){
        final Map<DomainEventType, List<DomainEventListener>> listeners=new HashMap<>();
        listeners.put(DomainEventType.ORDER_WAS_CREATED,List.of(orderCreatedListener));
        return Collections.unmodifiableMap(listeners);
    }
}
