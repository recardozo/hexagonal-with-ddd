package com.cardozo.domain.event;

@FunctionalInterface
public interface DomainEventListener {
    void onEvent(final DomainEvent domainEvent);
}
