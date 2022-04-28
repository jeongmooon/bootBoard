package com.sutdy.test.member.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sutdy.test.domain.member.Member;
import com.sutdy.test.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 생성자 주입으로가기
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public Long save(Member member) {
		String hasPw = bCryptPasswordEncoder.encode(member.getPassword());
		member.setPassword(hasPw);
		return memberRepository.save(member).getId();
	}
}
