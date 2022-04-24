package com.example.demo.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.entity.Board;
import com.example.demo.board.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/write")
	public String BoardWriteForm() {
		
		return "boardwrite";
	}
	
	@PostMapping("/board/writepro")
	public String BoardWritePro(Board board,MultipartFile file) throws Exception {		
		boardService.write(board,file);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model,
							@PageableDefault(page = 0, size=3, sort="id", direction = Sort.Direction.DESC)
							Pageable pageable, String searchKeyword) {
		
		Page<Board> list =null;		
		if(searchKeyword ==null) {
			list = boardService.boardList(pageable);
		} else {
			list= boardService.searchList(searchKeyword, pageable);
		}		
		
		int nowPage = list.getPageable().getPageNumber() +1;
		int startPage =Math.max(nowPage - 4, 1);
		int endPage = Math.min(nowPage+5, list.getTotalPages());
		
		model.addAttribute("list",list);		
		model.addAttribute("nowPage",nowPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		
		return "boardList";
	}
	
	@GetMapping("/board")
	public String boardGet(@RequestParam("id") Integer id, Model model) {
		System.out.println("test");
		model.addAttribute("board",boardService.boardGet(id));
		
		return "boardDetail";
	}
	
	@GetMapping("/board/delete")
	//@DeleteMapping("/board/delete")
	public String delete(@RequestParam("id") Integer id) {
		boardService.delete(id);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/{id}")
	public String modify(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("board",boardService.boardGet(id));
		
		return "boardModify";
	}
	
	@PostMapping("/board/update/{id}")
	public String modify(@PathVariable("id") Integer id, Board board, MultipartFile file) throws Exception {
		Board boardTemp = boardService.boardGet(id);
		boardTemp.setTitle(board.getTitle());
		boardTemp.setContent(board.getContent());
		boardService.write(boardTemp,file);
		
		return "redirect:/board/list";
	}
}
