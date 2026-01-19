package com.school.coffeemachine.api.dto;

import java.math.BigDecimal;

public class RecipeResponse {
    private Long id;
    private String name;
    private BigDecimal price;
    private int waterMl, milkMl, beansG, sugarG;

    public RecipeResponse() {}

    public RecipeResponse(Long id, String name, BigDecimal price, int waterMl, int milkMl, int beansG, int sugarG) {
        this.id = id; this.name = name; this.price = price;
        this.waterMl = waterMl; this.milkMl = milkMl; this.beansG = beansG; this.sugarG = sugarG;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public int getWaterMl() { return waterMl; }
    public int getMilkMl() { return milkMl; }
    public int getBeansG() { return beansG; }
    public int getSugarG() { return sugarG; }
}
