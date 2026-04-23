package com.example.demo.controller;

import com.example.demo.model.Collectivity;
import com.example.demo.repository.CollectivityJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/collectivities")
@AllArgsConstructor
public class CollectivityController {
    private final CollectivityJdbcRepository collectivityRepository;

    @GetMapping("/{id}")
    public Collectivity getById(@PathVariable String id) throws Exception {
        return collectivityRepository.findById(id);
    }
}