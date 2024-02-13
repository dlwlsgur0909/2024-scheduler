package com.example.scheduler.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    private String updatedBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

}
