package com.federation.controller;

import com.federation.model.Collectivity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/collectivities")
public class CollectivityController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Collectivity> createCollectivities(@RequestBody List<Collectivity> collectivities) {
        return collectivities;
    }
}
