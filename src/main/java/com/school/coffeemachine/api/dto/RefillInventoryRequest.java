package com.school.coffeemachine.api.dto;

import jakarta.validation.constraints.Min;

public class RefillInventoryRequest {
    @Min(0) private int waterMl;
    @Min(0) private int milkMl;
    @Min(0) private int beansG;
    @Min(0) private int sugarG;
    @Min(0) private int cups;

    public int getWaterMl() { return waterMl; }
    public int getMilkMl() { return milkMl; }
    public int getBeansG() { return beansG; }
    public int getSugarG() { return sugarG; }
    public int getCups() { return cups; }

    public void setWaterMl(int waterMl) { this.waterMl = waterMl; }
    public void setMilkMl(int milkMl) { this.milkMl = milkMl; }
    public void setBeansG(int beansG) { this.beansG = beansG; }
    public void setSugarG(int sugarG) { this.sugarG = sugarG; }
    public void setCups(int cups) { this.cups = cups; }
}
