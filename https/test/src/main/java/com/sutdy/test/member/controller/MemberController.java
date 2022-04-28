package com.sutdy.test.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/auth/user/user-save")
	public String userSave() {
		return "layout/user/user-save";
	}
	
	@GetMapping("/auth/user/login")
	public String userLogin() {
		return "layout/user/user-login";
	}
}
