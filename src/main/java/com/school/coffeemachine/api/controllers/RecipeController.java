package com.school.coffeemachine.api.controllers;

import com.school.coffeemachine.api.dto.CreateRecipeRequest;
import com.school.coffeemachine.api.dto.RecipeResponse;
import com.school.coffeemachine.domain.Recipe;
import com.school.coffeemachine.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeResponse create(@Valid @RequestBody CreateRecipeRequest req) {
        Recipe r = recipeService.create(req);
        return new RecipeResponse(r.getId(), r.getName(), r.getPrice(), r.getWaterMl(), r.getMilkMl(), r.getBeansG(), r.getSugarG());
    }

    @GetMapping
    public List<RecipeResponse> list() {
        return recipeService.list().stream()
                .map(r -> new RecipeResponse(r.getId(), r.getName(), r.getPrice(), r.getWaterMl(), r.getMilkMl(), r.getBeansG(), r.getSugarG()))
                .toList();
    }

    @GetMapping("/{id}")
    public RecipeResponse get(@PathVariable Long id) {
        Recipe r = recipeService.get(id);
        return new RecipeResponse(r.getId(), r.getName(), r.getPrice(), r.getWaterMl(), r.getMilkMl(), r.getBeansG(), r.getSugarG());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        recipeService.delete(id);
    }
}
