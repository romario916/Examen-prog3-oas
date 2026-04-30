package com.example.demo.service;

import com.example.demo.repository.MemberJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdmissionService {
    private final MemberJdbcRepository memberRepo;

    public boolean validateAdmission(String targetCollId, List<String> sponsorIds) throws Exception {
        if (sponsorIds.size() < 2) return false;

        int local = 0;
        int external = 0;

        for (String id : sponsorIds) {
            String collId = memberRepo.getCollectivityIdByMemberId(id);
            if (targetCollId.equals(collId)) {
                local++;
            } else {
                external++;
            }
        }
        return local >= external;
    }
}