package com.example.demo.mapper.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Member;

@Mapper
public interface MemberMapper {
	Member setMember(int id) throws Exception;
	int createMember(Member member) throws Exception;
}
