package com.cardozo.domain.event;

@FunctionalInterface
public interface DomainEventNotifier {
    void notify(final DomainEvent domainEvent);
}
