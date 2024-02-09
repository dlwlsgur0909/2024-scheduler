package com.example.scheduler.entity;

import com.example.scheduler.util.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "member_id")
    private String id;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private String memberNickname;
    private String memberActive;

}
