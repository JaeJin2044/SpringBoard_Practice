package com.java.board.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.board.model.ReplyEntity;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyMapper mapper;
	
	//댓글 조회 
	public List<ReplyEntity> replyList(int bno){
		return mapper.replyList(bno); 
	}
	
	//댓글 작성
	public int replyWrite(ReplyEntity param) {
		return mapper.replyWrite(param);
	}
	
	//댓글 수정 
	public int replyModify(ReplyEntity param) {
		return mapper.replyModify(param);
	}
	
	
	//댓글 삭제 
	public int replyDelete(ReplyEntity param) {
		return mapper.replyDelete(param);
	}

	
	
}













