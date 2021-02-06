package com.java.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.board.model.BoardEntity;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardEntity> list(){
		return mapper.selList();
	}
	
	public int write(BoardEntity p) {
		return mapper.insBoard(p);
	}
	public BoardEntity detail(BoardEntity p) {
		return mapper.selList_Unit(p);
	}
	
	public int delete(BoardEntity p) {
		return mapper.delBoard(p);
	}
	
	public int modBoard(BoardEntity p) {
		return mapper.modBoard(p);
	}
	public int count() {
		return mapper.count();
	}
	public List<BoardEntity> GetListPage(int displayPost, int postNum){
		HashMap data = new HashMap();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return mapper.listPage(data);
	}
	
	

}
