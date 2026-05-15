package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityInput {
    private String id;
    private String label;
    private String activityType;
    private LocalDate executiveDate;
    private String recurrenceRule;
}