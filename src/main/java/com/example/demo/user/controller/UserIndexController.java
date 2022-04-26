package com.sutdy.boot.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sutdy.boot.model.UserDto;
import com.sutdy.boot.user.service.CustomUserDetails;
import com.sutdy.boot.user.service.CustomUserDetailsService;
import com.sutdy.boot.user.service.UserService;

@Controller
public class UserIndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@GetMapping("/auth/join")
	public String join() {
		return "/user/user-join";
	}
	
	@PostMapping("/auth/joinProc")
	public String joinProc(UserDto userDto) {
		userService.join(userDto);
		
		return "redirect:/auth/login";
	}
	
	@GetMapping("/auth/login")
	public String login() {
		return "/user/user-login";
	}
	
	//@PostMapping("/auth/login")
	public String loginProc(UserDto userDto) {
		UserDetails user =customUserDetailsService.loadUserByUsername(userDto.getUsername());
				
		return "/board/list";
	}
}
