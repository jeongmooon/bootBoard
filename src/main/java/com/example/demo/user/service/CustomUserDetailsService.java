package com.sutdy.boot.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sutdy.boot.model.UserSessionDto;
import com.sutdy.boot.user.entity.UserT;
import com.sutdy.boot.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	private final HttpSession session;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserT user = userRepository.findByUsername(username).orElseThrow(()->
				new UsernameNotFoundException("�ش� ����ڰ� �������� �ʽ��ϴ�"+username));
				
		session.setAttribute("user", new UserSessionDto(user));
		
		// ��ť��Ƽ ���ǿ� ���� ��������
		return new CustomUserDetails(user);
	}

}
