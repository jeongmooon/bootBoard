package com.example.demo.mapper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Board;
import com.example.demo.dto.Search;
import com.example.demo.mapper.repository.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public BoardService() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	public int insertBoard(Board board) throws Exception {
		return boardMapper.insertBoard(board);
	}
	
	public Board selectBoard(int id) throws Exception {
		return boardMapper.selectBoard(id);
	}
	
	public Map<String, Object> selectBoardList(Search search) throws Exception {
		System.out.println("SEARCH" + search);
		
		List<Board> list = boardMapper.selectBoardList(search);
		int totalCount = boardMapper.selectBoardTotalCount(search);
		
		System.out.println("SEARCH" + search);
		
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("list", list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
}
