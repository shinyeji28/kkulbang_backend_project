package com.ssafy.model.dao.board;

import java.util.List;

import com.ssafy.model.dto.BoardDto;

public interface BoardDao {

	void registerArticle(BoardDto boardDto);

	List<BoardDto> searchListAll();

	List<BoardDto> searchListBySubject(String subject);

	BoardDto viewArticle(int no);

	void modifyArticle(BoardDto boardDto);

	void deleteArticle(int no);

}
