package com.example.demo.controller;

import com.example.demo.model.MembershipFee;
import com.example.demo.repository.MembershipFeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/collectivities/{id}/membership-fees")
@AllArgsConstructor
public class MembershipFeeController {
    private final MembershipFeeRepository feeRepository;

    @PostMapping
    public void addFees(@PathVariable String id, @RequestBody List<MembershipFee> fees) {
        try {
            for (MembershipFee fee : fees) {
                feeRepository.save(id, fee);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur d'ajout des cotisations", e);
        }
    }
}