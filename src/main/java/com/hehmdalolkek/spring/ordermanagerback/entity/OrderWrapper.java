package com.hehmdalolkek.spring.ordermanagerback.entity;

import java.util.List;

public class OrderWrapper {
    private Order order;
    private List<OrderDetail> orderDetails;

    public OrderWrapper() {
    }

    public OrderWrapper(Order order, List<OrderDetail> orderDetails) {
        this.order = order;
        this.orderDetails = orderDetails;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}