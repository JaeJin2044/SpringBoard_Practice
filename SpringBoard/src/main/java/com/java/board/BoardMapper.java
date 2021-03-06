package com.java.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.board.model.BoardEntity;

@Mapper
public interface BoardMapper {

	List<BoardEntity> selList();
	int insBoard(BoardEntity p);
	BoardEntity selList_Unit(BoardEntity p);
	int delBoard(BoardEntity p);
	int modBoard(BoardEntity p);
	//게시물 총 개수 
	int count();
	//게시물 목록 +페이징
	List<BoardEntity> listPage(HashMap data);
	
	//게시물 목록+페이징+검색
	List<BoardEntity> listPageSearch(HashMap data);
	
	//게시물 총개수 + 검색 적용
	public int searchCount(HashMap data);
	
	
}
