package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.demo.dto.Board;
import com.example.demo.dto.Member;
import com.example.demo.dto.Search;
import com.example.demo.mapper.controller.BoardController;
import com.example.demo.mapper.service.BoardService;
import com.example.demo.mapper.service.MemberService;

@SpringBootTest
class BootCodeTestApplicationTests {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BoardService boardService;
	
	
	@Test
	@Commit
	@DisplayName("»ý¼º")
	void contextLoads() throws Exception {
		/*
		Member m = new Member();
		m.setUserId("test5");
		m.setPassword("9788");
		
		int Cnt = memberService.createMember(m);
		assertThat(Cnt).isEqualTo(1);
		*/
		
		Search search = new Search();
		search.setPageSize(3);
		search.setCurrentPage(1);
		
		Map<String, Object> map =boardService.selectBoardList(search);
		List<Board> list = (List<Board>)map.get("list");
		
		System.out.println(map.get("totalCount"));
		
		for (Board board : list) {
			System.out.println("1 ¹ø"+board);
		}
	}

}
