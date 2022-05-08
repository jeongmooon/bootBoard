package com.sutdy.test.member.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sutdy.test.member.dto.MemberSaveRequestDto;
import com.sutdy.test.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
	private final MemberService memberService;
	
	@PostMapping("/auth/api/v1/user")
	public Long save(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
		return memberService.save(memberSaveRequestDto.toEntity());
	}
}
