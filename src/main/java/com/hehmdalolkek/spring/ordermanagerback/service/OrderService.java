package com.hehmdalolkek.spring.ordermanagerback.service;

import com.hehmdalolkek.spring.ordermanagerback.entity.Order;
import com.hehmdalolkek.spring.ordermanagerback.entity.OrderDetail;
import com.hehmdalolkek.spring.ordermanagerback.entity.OrderWrapper;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface OrderService {

    public OrderWrapper getOrderById(int id);

    public List<Order> getAllOrders();

    public OrderWrapper addOrder(@Valid Order order, @Valid List<OrderDetail> orderDetails);

    public OrderWrapper editOrderById(int id, @Valid Order newOrder, @Valid List<OrderDetail> newOrderDetails);

    public void deleteOrderById(int id);


}
