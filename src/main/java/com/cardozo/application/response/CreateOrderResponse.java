package com.cardozo.application.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;
@Getter
@AllArgsConstructor
public class CreateOrderResponse {
    private final UUID id;
}