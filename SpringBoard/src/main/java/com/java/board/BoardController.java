package com.java.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.board.model.BoardEntity;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	
	//게시물 목록 
	@GetMapping("/list")
	public void list(Model model) {
		List<BoardEntity> list = service.list();
		model.addAttribute("list", list);
	}

	//게시물 작성 
	@GetMapping("/write")
	public void write() {
	}

	//게시물 작성 
	@PostMapping("/write")
	public String writeAction(BoardEntity p) {
		int result = service.write(p);

		return "redirect: /board/list";
	}
	@GetMapping("/detail")
	public void detail(BoardEntity p,Model model) {
		model.addAttribute("data", service.detail(p));
	}
	
	//게시물 삭제 
	@GetMapping("/delete")
	public String delete(BoardEntity p) {
		service.delete(p);
		return "redirect:/board/list";
	}
	
	//게시물 수정 
	@GetMapping("/mod")
	public void modify(BoardEntity p,Model model) {
		model.addAttribute("data", p);
	}
	//게시물 수정
	@PostMapping("/mod")
	public String modify(BoardEntity p) {
		service.modBoard(p);
		return "redirect:/board/list";
	}
	//게시물 목록+페이징추가
	@GetMapping("/listPage")
	public void GetListPage(Model model, @RequestParam("num") int num) {
		
		
		//게시물 총개수
		int count = service.count();
		
		//한 페이지에 출력할 게시물 수 
		int postNum = 10;
		
		//하단 페이징 번호 ([게시물 총 개수 % 한 페이지에 출력할 갯수의 올림])
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		//출력할 게시물 
		int displayPost = ((num - 1) * postNum);
		
		//한번에 표시될 페이징 번호 
		int pageNum_cnt = 10;
		
		//
		
		List<BoardEntity> list = service.GetListPage(displayPost, postNum);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		
	}
	

}
