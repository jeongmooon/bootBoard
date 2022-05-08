package com.sutdy.test.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sutdy.test.member.repository.MemberRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {
	@Autowired
	MemberRepository memberRepository;
	
	@AfterEach
	public void cleanup() {
		memberRepository.deleteAll();
	}
	
	@Test
	public void 회원가입Test() {
		String username = "test";
		String nickname = "jungmoon";
		
		memberRepository.save(Member.builder()
					.username(username)
					.password("1234")
					.email("test@gmail.com")
					.nickname(nickname)
					.role(Role.USER)
					.build());
		
		// when
		List<Member> mList = memberRepository.findAll();
		
		Member m = mList.get(0);
		assertThat(m.getUsername()).isEqualTo(username);
		assertThat(m.getNickname()).isEqualTo(nickname);
	}
}
