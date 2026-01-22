package com.school.coffeemachine.service;

import com.school.coffeemachine.api.dto.RefillInventoryRequest;
import com.school.coffeemachine.domain.Inventory;
import com.school.coffeemachine.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {
    public static final long INVENTORY_ID = 1L;

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public Inventory getOrCreateDefault() {
        return inventoryRepository.findById(INVENTORY_ID).orElseGet(() -> {
            Inventory inv = new Inventory(INVENTORY_ID, 5000, 2000, 1000, 1000, 50);
            return inventoryRepository.save(inv);
        });
    }

    @Transactional
    public Inventory refill(RefillInventoryRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("Refill request body is required");
        }

        Inventory inv = getOrCreateDefault();

        inv.setWaterMl(safeAdd(inv.getWaterMl(), req.getWaterMl(), "waterMl"));
        inv.setMilkMl(safeAdd(inv.getMilkMl(), req.getMilkMl(), "milkMl"));
        inv.setBeansG(safeAdd(inv.getBeansG(), req.getBeansG(), "beansG"));
        inv.setSugarG(safeAdd(inv.getSugarG(), req.getSugarG(), "sugarG"));
        inv.setCups(safeAdd(inv.getCups(), req.getCups(), "cups"));

        return inventoryRepository.save(inv);
    }

    private int safeAdd(int current, int add, String field) {
        try {
            return Math.addExact(current, add);
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException("Refill amount is too large for field: " + field);
        }
    }
}
