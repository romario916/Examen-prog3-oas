package com.example.demo.model;

import com.example.demo.model.enums.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String id;
    private String collectivityId;
    private AccountType type;
    private String holderName;
    private String phoneNumber;
    private BigDecimal balance;
}