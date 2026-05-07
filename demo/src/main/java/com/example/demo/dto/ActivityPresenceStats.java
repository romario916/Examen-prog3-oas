package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityPresenceStats {
    private String activityLabel;
    private int totalMembers;
    private int presentCount;
    private double presenceRate;
}
