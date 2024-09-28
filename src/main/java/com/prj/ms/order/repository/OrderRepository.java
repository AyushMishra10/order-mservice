package com.prj.ms.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.ms.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
