package com.example.demo.controller;

import com.example.demo.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/{id}/payments")
    public void postPayment(
            @PathVariable String id,
            @RequestParam String memberId,
            @RequestParam BigDecimal amount,
            @RequestParam String accountId,
            @RequestParam String mode) {

        financialService.recordPayment(memberId, amount.doubleValue(), accountId, mode);
    }
}