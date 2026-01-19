package com.school.coffeemachine.api.dto;

import jakarta.validation.constraints.NotNull;

public class BrewRequest {
    @NotNull
    private Long recipeId;

    public Long getRecipeId() { return recipeId; }
    public void setRecipeId(Long recipeId) { this.recipeId = recipeId; }
}
