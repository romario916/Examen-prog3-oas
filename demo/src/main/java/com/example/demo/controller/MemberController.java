package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public List<Member> getAll() {
        return memberService.getAllMembers();
    }

    @PostMapping
    public void register(@RequestBody Member member) {
        memberService.registerMember(member);
    }
}