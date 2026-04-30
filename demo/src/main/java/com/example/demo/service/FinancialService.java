package com.example.demo.service;

import com.example.demo.repository.FinancialJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class FinancialService {

    private final FinancialJdbcRepository financialRepository;

    public void recordPayment(String memberId, double amount, String accountId, String mode) {
        try {
            financialRepository.savePayment(memberId, amount, accountId, mode);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'enregistrement du paiement en base", e);
        }
    }

    public BigDecimal getBalanceAtDate(String accountId, LocalDate at) {
        try {
            return financialRepository.calculateBalance(accountId, at);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération du solde", e);
        }
    }
}