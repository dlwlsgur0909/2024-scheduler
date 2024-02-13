package com.example.scheduler.service;

import com.example.scheduler.dto.request.MemberSaveRequest;
import com.example.scheduler.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(final MemberSaveRequest requestDTO) {
        memberRepository.save(requestDTO.toEntity());
    }
}
