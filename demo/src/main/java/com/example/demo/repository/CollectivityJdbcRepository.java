package com.example.demo.repository;

import com.example.demo.model.Collectivity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CollectivityJdbcRepository {
    @Value("${spring.datasource.url}") private String url;
    @Value("${spring.datasource.username}") private String user;
    @Value("${spring.datasource.password}") private String pwd;

    public Collectivity findById(String id) throws SQLException {
        String sql = "SELECT * FROM collectivities WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Collectivity(
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("unique_number")
                    );
                }
            }
        }
        return null;
    }
}