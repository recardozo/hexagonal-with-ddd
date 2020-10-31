package com.cardozo.domain.event;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DefaultDomainEventNotifier implements DomainEventNotifier {

    private final Map<DomainEventType, List<DomainEventListener>> listeners = new HashMap<>();

    public DefaultDomainEventNotifier(final Map<DomainEventType, List<DomainEventListener>> listeners) {
        this.listeners.putAll(listeners);
    }

    @Override
    public void notify(final DomainEvent domainEvent) {
        final DomainEventType eventType = domainEvent.getType();
        final List<DomainEventListener> listener = listeners.getOrDefault(eventType, Collections.emptyList());
        listener.forEach(domainEventListener -> domainEventListener.onEvent(domainEvent));
    }
}
