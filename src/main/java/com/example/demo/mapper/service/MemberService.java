package com.example.demo.mapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Member;
import com.example.demo.mapper.repository.MemberMapper;

@Service
public class MemberService {

	private final MemberMapper memberMapper;
	
	@Autowired
	public MemberService(MemberMapper memberMapper) {
		// TODO Auto-generated constructor stub
		this.memberMapper = memberMapper;
	}
	
	public Member setMember(int id) throws Exception{
		return memberMapper.setMember(id);
	}
	
	public int createMember(Member member) throws Exception{
		return memberMapper.createMember(member);
	}
	
}
