package com.example.demo.repository;

import com.example.demo.dto.CollectivityLocalStatistics;
import com.example.demo.dto.MemberDescription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.example.demo.dto.ActivityPresenceStats;

@Repository
@RequiredArgsConstructor
public class FinancialJdbcRepository {

    private final Connection connection;

    public BigDecimal getBalanceAtDate(String accountId, LocalDate date) throws SQLException {
        String sql = "SELECT SUM(amount) FROM collectivity_transaction WHERE account_id = ? AND creation_date <= ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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

    public List<CollectivityLocalStatistics> getLocalStats(String collectivityId, LocalDate from, LocalDate to) throws SQLException {
        List<CollectivityLocalStatistics> results = new ArrayList<>();

        String sql = """
            SELECT 
                m.id, m.first_name, m.last_name, m.email, m.occupation,
                COALESCE(SUM(p.amount), 0) as earned,
                (
                  SELECT COALESCE(SUM(f.amount), 0) 
                  FROM membership_fee f 
                  WHERE f.collectivity_id = ? AND f.status = 'ACTIVE'
                  AND f.eligible_from BETWEEN ? AND ?
                ) - COALESCE(SUM(p.amount), 0) as unpaid
            FROM member m
            JOIN collectivity_member cm ON m.id = cm.member_id
            LEFT JOIN member_payment p ON m.id = p.member_id 
                 AND p.creation_date BETWEEN ? AND ?
            WHERE cm.collectivity_id = ?
            GROUP BY m.id, m.first_name, m.last_name, m.email, m.occupation
            """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, collectivityId);
            ps.setDate(2, Date.valueOf(from));
            ps.setDate(3, Date.valueOf(to));
            ps.setDate(4, Date.valueOf(from));
            ps.setDate(5, Date.valueOf(to));
            ps.setString(6, collectivityId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MemberDescription member = new MemberDescription(
                            rs.getString("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("occupation")
                    );

                    results.add(new CollectivityLocalStatistics(
                            member,
                            rs.getDouble("earned"),
                            Math.max(0.0, rs.getDouble("unpaid"))
                    ));
                }
            }
        }
        return results;
    }

    public void savePayment(String memberId, double amount, String accountId, String mode) throws SQLException {
        String sql = "INSERT INTO member_payment (id, member_id, amount, payment_mode, account_id, creation_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, memberId);
            ps.setBigDecimal(3, BigDecimal.valueOf(amount));
            ps.setString(4, mode);
            ps.setString(5, accountId);
            ps.setDate(6, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        }
    }
    public List<ActivityPresenceStats> getActivityStats(String collectivityId) throws SQLException {
        List<ActivityPresenceStats> stats = new ArrayList<>();
        String sql = """
        SELECT 
            a.label,
            COUNT(p.member_id) as total,
            SUM(CASE WHEN p.status = 'PRESENT' THEN 1 ELSE 0 END) as presents
        FROM activity a
        LEFT JOIN activity_presence p ON a.id = p.activity_id
        WHERE a.collectivity_id = ?
        GROUP BY a.id, a.label
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, collectivityId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int total = rs.getInt("total");
                    int presents = rs.getInt("presents");
                    double rate = total > 0 ? (double) presents / total * 100 : 0;
                    stats.add(new ActivityPresenceStats(rs.getString("label"), total, presents, rate));
                }
            }
        }
        return stats;
    }
}