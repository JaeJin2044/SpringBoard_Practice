package com.java.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.board.model.BoardEntity;
import com.java.board.model.Page;
import com.java.board.model.ReplyEntity;
import com.java.board.reply.ReplyService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@Inject
	private ReplyService replyService;
	

	// 게시물 목록
	@GetMapping("/list")
	public void list(Model model) {
		List<BoardEntity> list = service.list();
		model.addAttribute("list", list);
	}

	@GetMapping("/write")
	public void write() {
	}

	// 게시물 작성
	@PostMapping("/write")
	public String writeAction(BoardEntity p) {
		int result = service.write(p);

		return "redirect: /board/list";
	}

	//게시물 조회 
	@GetMapping("/detail")
	public void detail(BoardEntity p, Model model) {
		model.addAttribute("data", service.detail(p));
		
		System.out.println(p.getBno());
		//댓글 조회 
		List<ReplyEntity> reply = replyService.replyList(p.getBno());

		model.addAttribute("reply", reply);
		
	}

	// 게시물 삭제
	@GetMapping("/delete")
	public String delete(BoardEntity p) {
		service.delete(p);
		return "redirect:/board/list";
	}

	// 게시물 수정
	@GetMapping("/mod")
	public void modify(BoardEntity p, Model model) {
		model.addAttribute("data", p);
	}

	// 게시물 수정
	@PostMapping("/mod")
	public String modify(BoardEntity p) {
		service.modBoard(p);
		return "redirect:/board/list";
	}

	// 게시물 목록+페이징추가
	@GetMapping("/listPage")
	public void GetListPage(Model model, @RequestParam("num") int num) {

		Page page = new Page();
		page.setNum(num);
		page.setCount(service.count());

		List<BoardEntity> list = service.GetListPage(page.getDisplayPost(), page.getPostNum());
		model.addAttribute("list", list);

		model.addAttribute("page", page);
		// 현재페이지
		model.addAttribute("select", num);

	}

	// 게시물 목록+페이징추가+검색추가
	@GetMapping("/listPageSearch")
	public void GetListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value="searchType", required=false ,defaultValue="title") String searchType,
			@RequestParam(value="keyword",required=false, defaultValue="") String keyword) {

		Page page = new Page();
		page.setNum(num);
		
		//page.setCount(service.count());
		page.setCount(service.searchCount(searchType, keyword));
		
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		
		List<BoardEntity> list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), keyword, searchType);
		model.addAttribute("list", list);

		model.addAttribute("page", page);
		// 현재페이지
		model.addAttribute("select", num);

	}

}
