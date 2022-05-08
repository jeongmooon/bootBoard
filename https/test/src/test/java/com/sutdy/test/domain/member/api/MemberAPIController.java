package com.sutdy.test.domain.member.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sutdy.test.domain.member.Member;
import com.sutdy.test.domain.member.Role;
import com.sutdy.test.member.dto.MemberSaveRequestDto;
import com.sutdy.test.member.repository.MemberRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberAPIController {
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    public void cleanup() throws Exception {
    	memberRepository.deleteAll();
    }

    @Test
    public void User_가입완료_테스트() throws Exception {
        //given
        String username = "test";
        String nickname = "jungmoon";

        MemberSaveRequestDto memberSaveRequestDto = MemberSaveRequestDto.builder()
                .username(username)
                .password("1234")
                .email("test@gmail.com")
                .nickname(nickname)
                .role(Role.USER)
                .build();

        String url = "http://localhost:" + port + "/api/v1/user";
        System.out.println(url);
        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, memberSaveRequestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Member> userList = memberRepository.findAll();
        assertThat(userList.get(0).getUsername()).isEqualTo(username);
        assertThat(userList.get(0).getNickname()).isEqualTo(nickname);
    }
}
