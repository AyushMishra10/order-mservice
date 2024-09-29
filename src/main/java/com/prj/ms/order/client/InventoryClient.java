package com.prj.ms.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "http://localhost:8183")
public interface InventoryClient {

    @GetMapping(value = "api/inventory")
    boolean isInStock(@RequestParam String skuCode, Integer quantity);
}
