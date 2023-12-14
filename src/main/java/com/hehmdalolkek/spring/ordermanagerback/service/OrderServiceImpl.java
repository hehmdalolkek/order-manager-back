package com.hehmdalolkek.spring.ordermanagerback.service;

import com.hehmdalolkek.spring.ordermanagerback.dao.OrderDetailRepository;
import com.hehmdalolkek.spring.ordermanagerback.dao.OrderRepository;
import com.hehmdalolkek.spring.ordermanagerback.entity.Order;
import com.hehmdalolkek.spring.ordermanagerback.entity.OrderDetail;
import com.hehmdalolkek.spring.ordermanagerback.entity.OrderWrapper;
import com.hehmdalolkek.spring.ordermanagerback.exceptions.OrderDetailsNotFoundException;
import com.hehmdalolkek.spring.ordermanagerback.exceptions.OrderNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Autowired
    public void setOrderDetailRepository(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    @Transactional
    public OrderWrapper getOrderById(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        List<OrderDetail> orderDetails = orderDetailRepository.findOrderDetailsByOrderId(id);
        if (orderDetails.isEmpty()) {
            throw new OrderDetailsNotFoundException(id);
        }

        return new OrderWrapper(order, orderDetails);

    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public OrderWrapper addOrder(Order order, List<OrderDetail> orderDetails) {
        LocalDateTime localDateTime = LocalDateTime.now();
        order.setCreateDate(String.valueOf(localDateTime));
        Order savedOrder = orderRepository.save(order);

        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrder(savedOrder);
            orderDetailRepository.save(orderDetail);
        }
        return new OrderWrapper(savedOrder, orderDetails);
    }

    @Override
    @Transactional
    public OrderWrapper editOrderById(int id, Order newOrder, List<OrderDetail> newOrderDetails) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        order.setUser(newOrder.getUser());
        order.setTotal(newOrder.getTotal());
        LocalDateTime localDateTime = LocalDateTime.now();
        order.setCreateDate(String.valueOf(localDateTime));
        Order savedOrder = orderRepository.save(order);

        orderDetailRepository.deleteOrderDetailsByOrderId(id);
        List<OrderDetail> savedOrderDetails = new ArrayList<>();
        for (OrderDetail orderDetail : newOrderDetails) {
            orderDetail.setOrder(savedOrder);
            savedOrderDetails.add(orderDetailRepository.save(orderDetail));
        }

        return new OrderWrapper(savedOrder, savedOrderDetails);
    }

    @Override
    @Transactional
    public void deleteOrderById(int id) {
        orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        orderDetailRepository.deleteOrderDetailsByOrderId(id);
        orderRepository.deleteById(id);
    }
}
