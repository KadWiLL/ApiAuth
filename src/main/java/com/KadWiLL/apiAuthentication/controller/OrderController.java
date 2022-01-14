package com.KadWiLL.apiAuthentication.controller;

import com.KadWiLL.apiAuthentication.model.Order;
import com.KadWiLL.apiAuthentication.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>>getOrders(){
        return ResponseEntity.ok().body(orderService.getOrders());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity getOrder(@PathVariable("id") Long id){
        Optional<Order> order = orderService.getOrder(id);
        return new ResponseEntity(order, HttpStatus.OK);
    }

    @PostMapping("/orders/save")
    public ResponseEntity<Order>saveOrder(@RequestBody Order order){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/orders/save").toUriString());
        return ResponseEntity.created(uri).body(orderService.saveOrder(order));
    }

    @PutMapping("/orders/update")
    public ResponseEntity<Order>updateOrder(@RequestBody Order order){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/orders/update").toUriString());
        return ResponseEntity.created(uri).body(orderService.updateOrder(order));
    }

    @DeleteMapping("/orders/delete/{id}")
    public ResponseEntity<?>deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
