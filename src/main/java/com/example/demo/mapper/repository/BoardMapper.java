package com.example.demo.mapper.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Board;
import com.example.demo.dto.Search;

@Mapper
public interface BoardMapper {
	public int insertBoard(Board board) throws Exception;
	public Board selectBoard(int id) throws Exception;
	public int updateBoard(Board board) throws Exception;
	List<Board> selectBoardList(Search search) throws Exception;
	public int selectBoardTotalCount(Search search) throws Exception;
}
