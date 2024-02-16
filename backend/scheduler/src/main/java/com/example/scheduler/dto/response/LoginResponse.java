package com.example.scheduler.dto.response;

import com.example.scheduler.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    private String memberId;
    private String memberNickname;

    public LoginResponse(Member member) {
        this.memberId = member.getId();
        this.memberNickname = member.getMemberNickname();
    }
}
