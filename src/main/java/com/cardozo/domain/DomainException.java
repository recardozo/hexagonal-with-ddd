package com.cardozo.domain;

public class DomainException extends  RuntimeException {
    DomainException(final String message) {
        super(message);
    }
}
