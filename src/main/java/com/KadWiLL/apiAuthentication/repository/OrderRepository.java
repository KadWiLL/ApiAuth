package com.KadWiLL.apiAuthentication.repository;

import com.KadWiLL.apiAuthentication.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);
}
