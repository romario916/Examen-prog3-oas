package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Repository
public class FinancialJdbcRepository {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String pwd;

    public BigDecimal getBalanceAtDate(String accountId, LocalDate date) throws SQLException {
        String sql = "SELECT SUM(amount) FROM collectivity_transactions WHERE account_id = ? AND creation_date <= ?";
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, accountId);
            ps.setDate(2, Date.valueOf(date));

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    BigDecimal res = rs.getBigDecimal(1);
                    return res != null ? res : BigDecimal.ZERO;
                }
            }
        }
        return BigDecimal.ZERO;
    }

    public void savePayment(String memberId, double amount, String accountId, String mode) throws SQLException {
        String sql = "INSERT INTO member_payments (id, member_id, amount, payment_mode, account_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, memberId);
            ps.setBigDecimal(3, BigDecimal.valueOf(amount));
            ps.setString(4, mode);
            ps.setString(5, accountId);

            ps.executeUpdate();
        }
    }
}