package com.example.demo.mapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Member;
import com.example.demo.mapper.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	public MemberController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	public String login(Member member) throws Exception{
		return "";
	}
	
	@GetMapping("/join")
	public String auth() throws Exception{
		return "/user/join";
	}
	
	@PostMapping("/auth/join")
	public String auth(Member member) throws Exception {
		memberService.createMember(member);
		
		return "redirect:/login";
	}
}
