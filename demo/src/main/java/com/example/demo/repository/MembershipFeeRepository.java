package com.example.demo.repository;

import com.example.demo.model.MembershipFee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

@Repository
public class MembershipFeeRepository {
    @Value("${spring.datasource.url}") private String url;
    @Value("${spring.datasource.username}") private String user;
    @Value("${spring.datasource.password}") private String pwd;

    public void save(String collectivityId, MembershipFee fee) throws SQLException {
        String sql = "INSERT INTO membership_fees (id, label, status, frequency, eligible_since, amount, collectivity_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fee.getId());
            ps.setString(2, fee.getLabel());
            ps.setString(3, fee.getStatus().name());
            ps.setString(4, fee.getFrequency().name());
            ps.setDate(5, Date.valueOf(fee.getEligibleSince()));
            ps.setDouble(6, fee.getAmount());
            ps.setString(7, collectivityId);
            ps.executeUpdate();
        }
    }
}