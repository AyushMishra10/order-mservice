package com.prj.ms.order.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.prj.ms.order.dto.OrderRequest;
import com.prj.ms.order.model.Order;
import com.prj.ms.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setSkuCode(orderRequest.skuCode());
		order.setPrice(orderRequest.price());
		order.setQuantity(orderRequest.quantity());
		orderRepository.save(order);
		log.info("Order Placed Successfully");
	}

}
