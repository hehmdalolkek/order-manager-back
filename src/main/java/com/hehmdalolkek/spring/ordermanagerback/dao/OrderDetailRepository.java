package com.hehmdalolkek.spring.ordermanagerback.dao;

import com.hehmdalolkek.spring.ordermanagerback.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    public List<OrderDetail> findOrderDetailsByOrderId(int id);

    public List<OrderDetail> deleteOrderDetailsByOrderId(int id);

}
