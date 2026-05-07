package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollectivityLocalStatistics {
    private MemberDescription memberDescription;
    private Double earnedAmount;
    private Double unpaidAmount;
}