package com.java.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.board.model.BoardEntity;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/list")
	public void list(Model model) {
		List<BoardEntity> list = service.list();
		model.addAttribute("list", list);
	}

	@GetMapping("/write")
	public void write() {
	}

	@PostMapping("/write")
	public String writeAction(BoardEntity p) {
		int result = service.write(p);

		return "redirect: /board/list";
	}
	@GetMapping("/detail")
	public void detail(BoardEntity p,Model model) {
		model.addAttribute("data", service.detail(p));
	}
	@GetMapping("/delete")
	public String delete(BoardEntity p) {
		service.delete(p);
		return "redirect:/board/list";
	}
	
	@GetMapping("/mod")
	public void modify(BoardEntity p,Model model) {
		model.addAttribute("data", p);
	}
	
	@PostMapping("/mod")
	public String modify(BoardEntity p) {
		service.modBoard(p);
		return "redirect:/board/list";
	}
	
	
	
	

}
