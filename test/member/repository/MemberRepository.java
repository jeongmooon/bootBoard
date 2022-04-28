package com.sutdy.test.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sutdy.test.domain.member.Member;

// 어노테이션 안해도 관리함
// JpaRepository<Entity타입, PK 타입>
public interface MemberRepository extends JpaRepository<Member, Long> {

}
