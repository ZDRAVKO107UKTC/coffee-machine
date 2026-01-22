package com.school.coffeemachine.api.controllers;

import com.school.coffeemachine.api.dto.InventoryResponse;
import com.school.coffeemachine.api.dto.RefillInventoryRequest;
import com.school.coffeemachine.domain.Inventory;
import com.school.coffeemachine.service.InventoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @GetMapping
    public InventoryResponse get() {
        Inventory inv = inventoryService.getOrCreateDefault();
        return new InventoryResponse(inv.getWaterMl(), inv.getMilkMl(), inv.getBeansG(), inv.getSugarG(), inv.getCups());
    }

    @PostMapping("/refill")
    public InventoryResponse post(RefillInventoryRequest req) {
        Inventory inv = inventoryService.refill(req);
        return new InventoryResponse(inv.getWaterMl(), inv.getMilkMl(), inv.getBeansG(), inv.getSugarG(), inv.getCups());
    }

}