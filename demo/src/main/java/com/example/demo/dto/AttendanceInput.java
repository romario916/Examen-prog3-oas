package com.example.demo.dto;

import lombok.Data;

@Data
public class AttendanceInput {
    private String memberIdentifier;
    private String attendanceStatus;
}