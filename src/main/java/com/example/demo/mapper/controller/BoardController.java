package com.example.demo.mapper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Board;
import com.example.demo.dto.Page;
import com.example.demo.dto.Search;
import com.example.demo.mapper.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	int pageUnit = 3;
	
	int pageSize =2;
	
	public BoardController() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@GetMapping("/board")
	public String insertBoard() throws Exception {
		return "/board/insertBoard";
	}
	
	@PostMapping("/board")
	public String insertBoard(Board board) throws Exception {
		int c = boardService.insertBoard(board);
		if(c==1) {
			System.out.println("¿Ï·á");
		}
		return "redirect:/board/1";
	}
	
	@GetMapping("/board/{id}")
	public String getBoard(@PathVariable int id, Model model) throws Exception {
		model.addAttribute("board",boardService.selectBoard(id));		
		
		return "/board/getBoard";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model, Search search) throws Exception {
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		Map<String,Object> map = boardService.selectBoardList(search);
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage",resultPage);
		model.addAttribute("search",search);
		
		return "/board/listBoard";
	}
}
