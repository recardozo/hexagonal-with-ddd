package com.cardozo.application;

import com.cardozo.application.request.AddProductRequest;
import com.cardozo.application.request.CreateOrderRequest;
import com.cardozo.domain.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    void createOrder(@RequestBody final CreateOrderRequest createOrderRequest) {
        orderService.createOrder(createOrderRequest.getProduct());

    }

    @PostMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addProduct(@PathVariable final String id, @RequestBody final AddProductRequest addProductRequest) {
        orderService.addProduct(id, addProductRequest.getProduct());
    }

    @DeleteMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteProduct(@PathVariable final String id, @RequestParam final String productId) {
        orderService.deleteProduct(id, productId);
    }

    @PostMapping("/{id}/complete")
    void completeOrder(@PathVariable final String id) {
        orderService.completeOrder(id);
    }
}