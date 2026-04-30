package com.example.demo.model;

import com.example.demo.model.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private String job;
    private String phone;
    private String email;
    private String occupation;
    private String collectivityId;
}