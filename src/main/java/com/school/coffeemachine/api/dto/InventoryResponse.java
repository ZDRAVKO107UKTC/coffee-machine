package com.school.coffeemachine.api.dto;

public class InventoryResponse {
    private int waterMl, milkMl, beansG, sugarG, cups;

    public InventoryResponse() {}

    public InventoryResponse(int waterMl, int milkMl, int beansG, int sugarG, int cups) {
        this.waterMl = waterMl; this.milkMl = milkMl; this.beansG = beansG; this.sugarG = sugarG; this.cups = cups;
    }

    public int getWaterMl() { return waterMl; }
    public int getMilkMl() { return milkMl; }
    public int getBeansG() { return beansG; }
    public int getSugarG() { return sugarG; }
    public int getCups() { return cups; }
}
