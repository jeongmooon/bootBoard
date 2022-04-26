package com.sutdy.boot.user.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sutdy.boot.model.UserDto;
import com.sutdy.boot.model.UserSessionDto;
import com.sutdy.boot.user.entity.UserT;
import com.sutdy.boot.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder encoder;
	
	@Transactional
	public Long join(UserDto dto) {
		dto.setPassword(encoder.encode(dto.getPassword()));
		
		return userRepository.save(dto.toEntity()).getId();
	}
	
}
