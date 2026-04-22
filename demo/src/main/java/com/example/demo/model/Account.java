package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    private String collectivityId;
    private AccountType type;
    private String phoneNumber;
    private BigDecimal balance;

    public enum AccountType {
        CASH, ORANGE_MONEY, BANQUE
    }
}