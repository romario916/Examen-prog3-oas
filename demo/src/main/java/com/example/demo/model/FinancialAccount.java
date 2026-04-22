package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FinancialAccount {
    String getAccountId();
    BigDecimal getBalance(LocalDate at);
}