package com.school.coffeemachine.api.controllers;

import com.school.coffeemachine.api.dto.BrewRequest;
import com.school.coffeemachine.api.dto.BrewResponse;
import com.school.coffeemachine.service.BrewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BrewController {
    private final BrewService brewService;

    public BrewController(BrewService brewService) {
        this.brewService = brewService;
    }

    @PostMapping("/brew")
    public BrewResponse brew(@Valid @RequestBody BrewRequest req) {
        brewService.brew(req.getRecipeId());
        return new BrewResponse("SUCCESS", "Coffee brewed successfully.");
    }
}
