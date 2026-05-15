package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ProjectConfig {

    @Bean
    public Connection connection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/federation_agricole_db";
        String user = "federation_admin";
        String password = "123456";

        return DriverManager.getConnection(url, user, password);
    }
}