package com.prj.ms.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prj.ms.order.dto.OrderRequest;
import com.prj.ms.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	@PostMapping("/addOrder")
	@ResponseStatus(HttpStatus.CREATED)
	public void placeOrder(@RequestBody OrderRequest orderRequest) {
		//used DTO class for decoupling
		orderService.placeOrder(orderRequest);
		
		
	}

}
