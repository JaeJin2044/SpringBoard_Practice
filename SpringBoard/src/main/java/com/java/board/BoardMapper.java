package com.java.board;

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
	
}
