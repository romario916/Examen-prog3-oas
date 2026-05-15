package com.example.demo.controller;

import com.example.demo.dto.CollectivityLocalStatistics;
import com.example.demo.dto.CollectivityOverallStatistics;
import com.example.demo.repository.FinancialJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/collectivities")
@RequiredArgsConstructor
public class StatisticsController {

    private final FinancialJdbcRepository financialRepository;

    @GetMapping("/statistics")
    public ResponseEntity<List<CollectivityOverallStatistics>> getGlobalStats() throws SQLException {
        return ResponseEntity.ok(financialRepository.getOverallStats());
    }

    @GetMapping("/{id}/statistics")
    public ResponseEntity<List<CollectivityLocalStatistics>> getLocalStats(
            @PathVariable String id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) throws SQLException {

        return ResponseEntity.ok(financialRepository.getLocalStats(id, from, to));
    }
}