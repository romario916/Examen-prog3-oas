package com.example.demo.repository;

import com.example.demo.model.Member;
import com.example.demo.model.enums.Gender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberJdbcRepository {
    @Value("${spring.datasource.url}") private String url;
    @Value("${spring.datasource.username}") private String user;
    @Value("${spring.datasource.password}") private String pwd;

    public List<Member> findAll() throws SQLException {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                members.add(new Member(
                        rs.getString("id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        Gender.valueOf(rs.getString("gender")),
                        rs.getString("address"),
                        rs.getString("job"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("occupation"),
                        rs.getString("collectivity_id")
                ));
            }
        }
        return members;
    }

    public void save(Member m) throws SQLException {
        String sql = "INSERT INTO members (id, last_name, first_name, birth_date, gender, address, job, phone, email, occupation, collectivity_id) VALUES (?, ?, ?, ?, CAST(? AS gender_enum), ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getId());
            ps.setString(2, m.getLastName());
            ps.setString(3, m.getFirstName());
            ps.setDate(4, Date.valueOf(m.getBirthDate()));
            ps.setString(5, m.getGender().name());
            ps.setString(6, m.getAddress());
            ps.setString(7, m.getJob());
            ps.setString(8, m.getPhone());
            ps.setString(9, m.getEmail());
            ps.setString(10, m.getOccupation());
            ps.setString(11, m.getCollectivityId());
            ps.executeUpdate();
        }
    }

    public String getCollectivityIdByMemberId(String memberId) throws SQLException {
        String sql = "SELECT collectivity_id FROM members WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, memberId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getString("collectivity_id");
            }
        }
        return null;
    }
}