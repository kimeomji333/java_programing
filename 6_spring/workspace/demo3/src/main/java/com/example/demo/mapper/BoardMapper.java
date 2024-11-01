package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.BoardDTO;
import com.example.demo.domain.Criteria;

@Mapper
public interface BoardMapper {
	List<BoardDTO> getList(Criteria cri);
	long getTotal();
	int insertBoard(BoardDTO board);
	BoardDTO getBoardByBoardnum(long boardnum);
}
