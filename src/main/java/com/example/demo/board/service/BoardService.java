package com.example.demo.board.service;


import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepositoy;
	
	public void write(Board board, MultipartFile file) throws Exception {
		
		String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\files";
		
		UUID uuid = UUID.randomUUID();
		
		String fileName = uuid+"_"+file.getOriginalFilename();
		
		File saveFile = new File(projectPath,fileName);
		file.transferTo(saveFile);
		board.setFilename(fileName);
		board.setFilepath(projectPath);
		
		boardRepositoy.save(board);
	}
	
	public Page<Board> boardList(Pageable pageable){
		return boardRepositoy.findAll(pageable);
	}
	
	public Board boardGet(Integer id) {
		Optional<Board> board= boardRepositoy.findById(id);
		
		return board.get();
	}
	
	public void delete(Integer id) {
		boardRepositoy.deleteById(id);
	}
	
	public Page<Board> searchList(String searchKeyword, Pageable pageable){
		return boardRepositoy.findByTitleContaining(searchKeyword,pageable);
	}
}
