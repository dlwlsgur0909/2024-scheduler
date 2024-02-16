package com.example.scheduler.controller;

import com.example.scheduler.dto.request.LoginRequest;
import com.example.scheduler.dto.request.MemberSaveRequest;
import com.example.scheduler.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> saveMember(@RequestBody @Valid MemberSaveRequest requestDTO) {

        memberService.saveMember(requestDTO);

        return ResponseEntity
                .ok()
                .build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest requestDTO) {

        return ResponseEntity
                .ok()
                .body(memberService.login(requestDTO));
    }
}
