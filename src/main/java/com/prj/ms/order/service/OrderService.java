package com.prj.ms.order.service;

import java.util.UUID;

import com.prj.ms.order.client.InventoryClient;
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
	private final InventoryClient inventoryClient;
	
	public void placeOrder(OrderRequest orderRequest) {

		var isInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

		if(isInStock) {

			Order order = new Order();
			order.setOrderNumber(UUID.randomUUID().toString());
			order.setSkuCode(orderRequest.skuCode());
			order.setPrice(orderRequest.price());
			order.setQuantity(orderRequest.quantity());
			orderRepository.save(order);
			log.info("Order Placed Successfully");
		} else {
			throw new RuntimeException("Product with sku code" + orderRequest.skuCode() + " is not in stock");
		}
	}

}
