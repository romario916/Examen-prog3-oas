package com.example.demo.controller;

import com.example.demo.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/collectivities")
@AllArgsConstructor
public class FinancialController {

    private final FinancialService financialService;

    @GetMapping("/{id}/financialAccounts")
    public BigDecimal getBalance(
            @PathVariable String id,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate at) {

        LocalDate dateToUse = (at != null) ? at : LocalDate.now();

        return financialService.getBalanceAtDate(id, dateToUse);
    }
}