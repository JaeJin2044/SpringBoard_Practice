package com.java.board.reply;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.board.model.ReplyEntity;

@Mapper
public interface ReplyMapper {

	//댓글 조회
	List<ReplyEntity> replyList(int bno);
	//댓글 작성
	int replyWrite(ReplyEntity param);
	
	//댓글 수정 
	int replyModify(ReplyEntity param);
	//댓글 삭제 
	int replyDelete(ReplyEntity param);
}
