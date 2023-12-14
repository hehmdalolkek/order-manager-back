package com.hehmdalolkek.spring.ordermanagerback.controller;

import com.hehmdalolkek.spring.ordermanagerback.entity.Order;
import com.hehmdalolkek.spring.ordermanagerback.entity.OrderDetail;
import com.hehmdalolkek.spring.ordermanagerback.entity.OrderWrapper;
import com.hehmdalolkek.spring.ordermanagerback.entity.Product;
import com.hehmdalolkek.spring.ordermanagerback.service.OrderService;
import com.hehmdalolkek.spring.ordermanagerback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class OrderRestController {

    private OrderService orderService;
    private ProductService productService;
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public OrderWrapper getOrderById(@PathVariable("id") int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public OrderWrapper addOrder(@RequestBody OrderWrapper orderWrapper) {
        Order order = orderWrapper.getOrder();
        List<OrderDetail> orderDetails = orderWrapper.getOrderDetails();
        return orderService.addOrder(order, orderDetails);
    }

    @PutMapping("/orders/{id}")
    public OrderWrapper editOrder(@PathVariable("id") int id, @RequestBody OrderWrapper orderWrapper) {
        Order order = orderWrapper.getOrder();
        List<OrderDetail> orderDetails = orderWrapper.getOrderDetails();
        return orderService.editOrderById(id, order, orderDetails);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrderById(@PathVariable("id") int id) {
        orderService.deleteOrderById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
