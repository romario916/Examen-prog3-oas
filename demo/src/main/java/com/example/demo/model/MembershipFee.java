package com.example.demo.model;

import com.example.demo.model.enums.Frequency;
import com.example.demo.model.enums.ActivityStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembershipFee {
    private String id;
    private String label;
    private ActivityStatus status;
    private Frequency frequency;
    private LocalDate eligibleSince;
    private double amount;
    private String collectivityId;
}