package com.example.scheduler.repository;

import com.example.scheduler.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findByMemberEmail(final String memberEmail) {

        String sql = "select m from Member m where memberEmail = :memberEmail";

        List<Member> memberList = em.createQuery(sql, Member.class)
                .setParameter("memberEmail", memberEmail)
                .getResultList();

        if(memberList.size() != 1) {
            return null;
        }

        return memberList.get(0);
    }


}
