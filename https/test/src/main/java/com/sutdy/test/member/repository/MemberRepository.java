package com.sutdy.test.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sutdy.test.domain.member.Member;

// ������̼� ���ص� ������
// JpaRepository<EntityŸ��, PK Ÿ��>
public interface MemberRepository extends JpaRepository<Member, Long> {

}
