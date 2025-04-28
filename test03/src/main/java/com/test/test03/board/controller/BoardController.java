package com.test.test03.board.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.test03.board.dto.BoardDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		for (int i=0;i<10;i++) {
			BoardDTO b = new BoardDTO();
			
			b.setArticleNo(i);
			b.setTitle("안녕하세요"+i);
			b.setContent("테스트 데이터 입니다"+i);
			b.setWriteDate(new Date(125, 4, 1));
			b.setId("hong"+i);
			boardList.add(b);
		}
		model.addAttribute("boardList", boardList);
		return "board/boardList";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		//model.addAttribute("user", "user");
		model.addAttribute("price", 100);
		model.addAttribute("quantity", 10);
		
		return "board/test";
	}
	
}
