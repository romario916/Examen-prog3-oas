package com.example.demo.repository;

import com.example.demo.dto.CollectivityLocalStatistics;
import com.example.demo.dto.CollectivityOverallStatistics;
import com.example.demo.dto.MemberDescription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.CollectivityInformation;

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


@Repository
@RequiredArgsConstructor
public class FinancialJdbcRepository {

    private final Connection connection;

    public BigDecimal getBalanceAtDate(String accountId, LocalDate date) throws SQLException {
        String sql = "SELECT SUM(amount) FROM collectivity_transactions WHERE account_id = ? AND creation_date <= ?";
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
                COALESCE(payments.total_earned, 0) as earned,
                COALESCE(fees.total_fees, 0) - COALESCE(payments.total_earned, 0) as unpaid,
                COALESCE(att.rate, 0.0) as attendance_rate
            FROM members m
            LEFT JOIN (
                SELECT member_id, SUM(amount) as total_earned
                FROM member_payments
                WHERE creation_date BETWEEN ? AND ?
                GROUP BY member_id
            ) payments ON m.id = payments.member_id
            LEFT JOIN (
                SELECT collectivity_id, SUM(amount) as total_fees
                FROM membership_fees
                WHERE status = 'ACTIVE' AND eligible_since <= ?
                GROUP BY collectivity_id
            ) fees ON m.collectivity_id = fees.collectivity_id
            LEFT JOIN (
                SELECT 
                    ama.member_id,
                    (COUNT(CASE WHEN ama.attendance_status = 'ATTENDED' THEN 1 END) * 100.0 / NULLIF(COUNT(*), 0)) as rate
                FROM activity_member_attendance ama
                JOIN collectivity_activities ca ON ama.activity_id = ca.id
                WHERE ca.executive_date BETWEEN ? AND ?
                GROUP BY ama.member_id
            ) att ON m.id = att.member_id
            WHERE m.collectivity_id = ?
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(from));
            ps.setDate(2, Date.valueOf(to));
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

                    results.add(CollectivityLocalStatistics.builder()
                            .memberDescription(member)
                            .earnedAmount(rs.getDouble("earned"))
                            .unpaidAmount(Math.max(0.0, rs.getDouble("unpaid")))
                            .attendanceRate(rs.getDouble("attendance_rate"))
                            .build());
                }
            }
        }
        return results;
    }

    public void savePayment(String memberId, double amount, String accountId, String mode) throws SQLException {
        String sql = "INSERT INTO member_payments (id, member_id, amount, payment_mode, account_id, creation_date) VALUES (?, ?, ?, ?, ?, ?)";
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

    public List<CollectivityOverallStatistics> getOverallStats() throws SQLException {
        List<CollectivityOverallStatistics> results = new ArrayList<>();

        String sql = """
            SELECT 
                c.name, 
                COUNT(DISTINCT m.id) as member_count,
                COALESCE(
                    (SELECT COUNT(CASE WHEN attendance_status = 'ATTENDED' THEN 1 END) * 100.0 / NULLIF(COUNT(*), 0)
                     FROM activity_member_attendance ama
                     JOIN collectivity_activities ca ON ama.activity_id = ca.id
                     WHERE ca.collectivity_id = c.id), 0.0
                ) as global_attendance_rate
            FROM collectivities c
            LEFT JOIN members m ON c.id = m.collectivity_id
            GROUP BY c.id, c.name
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    results.add(CollectivityOverallStatistics.builder()
                            .collectivityInformation(CollectivityInformation.builder()
                                    .name(rs.getString("name"))
                                    .number(rs.getInt("member_count"))
                                    .build())
                            .overallAttendanceRate(rs.getDouble("global_attendance_rate"))
                            .build());
                }
            }
        }
        return results;
    }
}