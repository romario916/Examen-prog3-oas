package com.example.demo.service;

import com.example.demo.model.Member;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private static final List<Member> membersDb = new ArrayList<>();

    public void admitMember(String targetColId, Member member, List<String> sponsorIds) {
        if (sponsorIds == null || sponsorIds.size() < 2) {
            throw new RuntimeException("Admission denied: minimum 2 sponsors required.");
        }

        long localSponsors = sponsorIds.stream()
                .filter(id -> isFromCollectivity(id, targetColId)).count();
        long otherSponsors = sponsorIds.size() - localSponsors;

        if (localSponsors < otherSponsors) {
            throw new RuntimeException("Admission denied: insufficient local sponsors.");
        }

        member.setCollectivityId(targetColId);
        membersDb.add(member);
    }

    private boolean isFromCollectivity(String memberId, String colId) {
        for (Member m : membersDb) {
            if (m.getId().equals(memberId) && m.getCollectivityId().equals(colId)) {
                return true;
            }
        }
        return false;
    }
}