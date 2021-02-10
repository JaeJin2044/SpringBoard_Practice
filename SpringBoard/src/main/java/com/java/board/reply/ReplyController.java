package com.java.board.reply;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.board.model.ReplyEntity;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	private ReplyService service;
	
	
	//댓글 작성 
	@PostMapping("/write")
	public String replyWrite(ReplyEntity param) {
		System.out.println("bno = "+param.getBno());
		System.out.println("writer = "+param.getWriter());
		System.out.println("content = "+param.getContent());
		service.replyWrite(param);
		
		return "redirect:/board/detail?bno="+param.getBno();
		
	}
	
	
}
