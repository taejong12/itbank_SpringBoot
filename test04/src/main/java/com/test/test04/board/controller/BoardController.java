package com.test.test04.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.test04.board.dao.BoardDAO;
import com.test.test04.board.dto.BoardDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardDAO dao;
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<BoardDTO> boardList = dao.boardList();
		model.addAttribute("boardList", boardList);
		return "board/boardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		return "board/insertBoard";
	}
}





