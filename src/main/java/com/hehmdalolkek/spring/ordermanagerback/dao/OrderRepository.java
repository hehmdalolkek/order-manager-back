package com.hehmdalolkek.spring.ordermanagerback.dao;

import com.hehmdalolkek.spring.ordermanagerback.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
