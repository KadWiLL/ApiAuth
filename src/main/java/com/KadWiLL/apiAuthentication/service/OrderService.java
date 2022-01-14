package com.KadWiLL.apiAuthentication.service;

import com.KadWiLL.apiAuthentication.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Order saveOrder(Order order);
    public List<Order>getOrders();
    public Optional<Order> getOrder(Long id);
    public Order updateOrder(Order order);
    public void deleteOrderById(Long id);
}
