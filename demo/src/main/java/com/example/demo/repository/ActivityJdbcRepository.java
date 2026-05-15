package com.example.demo.repository;

import com.example.demo.dto.ActivityInput;
import com.example.demo.dto.AttendanceResponse;
import com.example.demo.dto.ActivityPresenceStats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ActivityJdbcRepository {

    private final Connection connection;

    public void saveActivities(String collectivityId, List<ActivityInput> activities) throws SQLException {
        String sql = "INSERT INTO collectivity_activities (id, collectivity_id, label, activity_type, executive_date, recurrence_rule) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (ActivityInput act : activities) {
                ps.setString(1, act.getId());
                ps.setString(2, collectivityId);
                ps.setString(3, act.getLabel());
                ps.setString(4, act.getActivityType());
                ps.setDate(5, act.getExecutiveDate() != null ? Date.valueOf(act.getExecutiveDate()) : null);
                ps.setString(6, act.getRecurrenceRule());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    public List<ActivityInput> findActivitiesByCollectivity(String collectivityId) throws SQLException {
        String sql = "SELECT id, label, activity_type, executive_date, recurrence_rule FROM collectivity_activities WHERE collectivity_id = ?";
        List<ActivityInput> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, collectivityId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ActivityInput act = new ActivityInput();
                    act.setId(rs.getString("id"));
                    act.setLabel(rs.getString("label"));
                    act.setActivityType(rs.getString("activity_type"));
                    Date date = rs.getDate("executive_date");
                    if (date != null) {
                        act.setExecutiveDate(date.toLocalDate());
                    }
                    act.setRecurrenceRule(rs.getString("recurrence_rule"));
                    list.add(act);
                }
            }
        }
        return list;
    }

    public void saveOrUpdateAttendance(String activityId, String memberId, String status) throws SQLException {
        String checkSql = "SELECT attendance_status FROM activity_member_attendance WHERE activity_id = ? AND member_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(checkSql)) {
            ps.setString(1, activityId);
            ps.setString(2, memberId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String currentStatus = rs.getString("attendance_status");
                    if ("ATTENDED".equals(currentStatus) || "MISSING".equals(currentStatus)) {
                        throw new IllegalArgumentException("Statut deja verrouille");
                    }
                    String updateSql = "UPDATE activity_member_attendance SET attendance_status = ? WHERE activity_id = ? AND member_id = ?";
                    try (PreparedStatement ups = connection.prepareStatement(updateSql)) {
                        ups.setString(1, status);
                        ups.setString(2, activityId);
                        ups.setString(3, memberId);
                        ups.executeUpdate();
                    }
                } else {
                    String insertSql = "INSERT INTO activity_member_attendance (activity_id, member_id, attendance_status) VALUES (?, ?, ?)";
                    try (PreparedStatement ips = connection.prepareStatement(insertSql)) {
                        ips.setString(1, activityId);
                        ips.setString(2, memberId);
                        ips.setString(3, status);
                        ips.executeUpdate();
                    }
                }
            }
        }
    }

    public List<AttendanceResponse> findAttendanceByActivity(String activityId) throws SQLException {
        String sql = """
            SELECT m.id, m.first_name, m.last_name, m.email, m.occupation, ama.attendance_status 
            FROM activity_member_attendance ama
            JOIN members m ON ama.member_id = m.id
            WHERE ama.activity_id = ? AND ama.attendance_status = 'ATTENDED'
        """;
        List<AttendanceResponse> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, activityId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new AttendanceResponse(
                            rs.getString("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("occupation"),
                            rs.getString("attendance_status")
                    ));
                }
            }
        }
        return list;
    }

    public List<ActivityPresenceStats> getActivityStats(String collectivityId) throws SQLException {
        List<ActivityPresenceStats> stats = new ArrayList<>();
        String sql = """
        SELECT 
            a.label,
            COUNT(p.member_id) as total,
            SUM(CASE WHEN p.attendance_status = 'ATTENDED' THEN 1 ELSE 0 END) as presents
        FROM collectivity_activities a
        LEFT JOIN activity_member_attendance p ON a.id = p.activity_id
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