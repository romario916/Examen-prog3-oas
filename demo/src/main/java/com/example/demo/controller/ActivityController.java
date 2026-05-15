package com.example.demo.controller;

import com.example.demo.dto.ActivityInput;
import com.example.demo.dto.AttendanceInput;
import com.example.demo.dto.AttendanceResponse;
import com.example.demo.repository.ActivityJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/collectivities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityJdbcRepository activityRepository;

    @PostMapping("/{id}/activities")
    public ResponseEntity<String> addActivities(
            @PathVariable String id,
            @RequestBody List<ActivityInput> activities) throws SQLException {
        activityRepository.saveActivities(id, activities);
        return ResponseEntity.status(HttpStatus.CREATED).body("Activités enregistrées !");
    }

    @GetMapping("/{id}/activities")
    public ResponseEntity<List<ActivityInput>> getActivities(@PathVariable String id) throws SQLException {
        return ResponseEntity.ok(activityRepository.findActivitiesByCollectivity(id));
    }

    @PostMapping("/{id}/activities/{activityId}/attendance")
    public ResponseEntity<String> recordAttendance(
            @PathVariable String id,
            @PathVariable String activityId,
            @RequestBody List<AttendanceInput> attendanceList) {
        try {
            for (AttendanceInput att : attendanceList) {
                activityRepository.saveOrUpdateAttendance(
                        activityId,
                        att.getMemberIdentifier(),
                        att.getAttendanceStatus()
                );
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Assiduité mise à jour !");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur SQL.");
        }
    }

    @GetMapping("/{id}/activities/{activityId}/attendance")
    public ResponseEntity<List<AttendanceResponse>> getAttendance(
            @PathVariable String id,
            @PathVariable String activityId) throws SQLException {
        return ResponseEntity.ok(activityRepository.findAttendanceByActivity(activityId));
    }
}