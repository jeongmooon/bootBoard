package com.sutdy.test.member.dto;

import com.sutdy.test.domain.member.Member;
import com.sutdy.test.domain.member.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {
	private String username;
    private String password;
    private String email;
    private String nickname;
    private Role role;

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .role(Role.USER)
                .build();
    }
}
