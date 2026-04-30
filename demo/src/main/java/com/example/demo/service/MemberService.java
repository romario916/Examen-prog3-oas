package com.example.demo.service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberJdbcRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberJdbcRepository memberRepository;

    public List<Member> getAllMembers() {
        try {
            return memberRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erreur de récupération des membres", e);
        }
    }

    public void registerMember(Member member) {
        try {
            memberRepository.save(member);
        } catch (Exception e) {
            throw new RuntimeException("Erreur d'inscription", e);
        }
    }
}