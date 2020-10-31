package com.cardozo.domain.event;

import java.util.EventObject;

public abstract class DomainEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public DomainEvent(final Object source) {
        super(source);
    }

    public abstract DomainEventType getType();
}
