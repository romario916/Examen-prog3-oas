package com.example.demo.service;

import com.example.demo.model.Transaction;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FinancialService {
    private static final List<Transaction> transactionsDb = new ArrayList<>();

    public void recordPayment(String accountId, BigDecimal amount) {
        Transaction tx = new Transaction();
        tx.setAccountId(accountId);
        tx.setAmount(amount);
        tx.setTransactionDate(LocalDate.now());
        transactionsDb.add(tx);
    }

    public BigDecimal getBalanceAtDate(String accountId, LocalDate at) {
        BigDecimal total = BigDecimal.ZERO;
        for (Transaction tx : transactionsDb) {
            if (tx.getAccountId().equals(accountId)) {
                if (!tx.getTransactionDate().isAfter(at)) {
                    total = total.add(tx.getAmount());
                }
            }
        }
        return total;
    }
}