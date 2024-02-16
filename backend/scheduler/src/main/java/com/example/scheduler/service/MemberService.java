package com.example.scheduler.service;

import com.example.scheduler.dto.request.LoginRequest;
import com.example.scheduler.dto.request.MemberSaveRequest;
import com.example.scheduler.dto.response.LoginResponse;
import com.example.scheduler.entity.Member;
import com.example.scheduler.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(final MemberSaveRequest requestDTO) {

        Member duplicateMember = memberRepository.findByMemberEmail(requestDTO.getMemberEmail());

        if(duplicateMember != null ) {
            throw new RuntimeException("Duplicate Email");
        }

        String rawPassword = requestDTO.getMemberPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        memberRepository.save(requestDTO.toEntity(encodedPassword));
    }

    @Transactional
    public LoginResponse login(final LoginRequest requestDTO) {

        String memberEmail = requestDTO.getMemberEmail();
        String memberPassword = requestDTO.getMemberPassword();

        Member findMember = memberRepository.findByMemberEmail(memberEmail);

        if(findMember == null) {
            throw new RuntimeException("Login Failed");
        }

        boolean matches = passwordEncoder.matches(memberPassword, findMember.getMemberPassword());

        if(!matches) {
            throw new RuntimeException("Login Failed");
        }

        return new LoginResponse(findMember);
    }
}
