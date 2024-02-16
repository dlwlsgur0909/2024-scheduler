package com.example.scheduler.dto.request;

import com.example.scheduler.entity.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberSaveRequest {

    @NotBlank
    private String memberName;
    @NotBlank
    private String memberEmail;
    @NotBlank
    private String memberPassword;
    @NotBlank
    private String memberNickname;

    public Member toEntity(String encodedPassword) {

        return Member.builder()
                .memberName(memberName)
                .memberEmail(memberEmail)
                .memberPassword(encodedPassword)
                .memberNickname(memberNickname)
                .memberActive("ACTIVE")
                .createdBy(memberName)
                .createdAt(LocalDateTime.now())
                .updatedBy(memberName)
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
