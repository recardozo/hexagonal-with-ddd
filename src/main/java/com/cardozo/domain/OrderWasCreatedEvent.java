package com.cardozo.domain;

import com.cardozo.domain.event.DomainEvent;
import com.cardozo.domain.event.DomainEventType;

public class OrderWasCreatedEvent extends DomainEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public OrderWasCreatedEvent(final Order source) {
        super(source);
    }

    @Override
    public DomainEventType getType() {
        return DomainEventType.ORDER_WAS_CREATED;
    }

}
