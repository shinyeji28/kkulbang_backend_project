package com.ssafy.home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.board.model.service.BoardService;


/**
 * Servlet implementation class HomeController
 */
@WebServlet("")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BoardService boardService = BoardServiceImpl.getBoardService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			getNoticeList(request,response);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}


	private void getNoticeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<BoardDto> notices = boardService.getNoticeList();
		request.setAttribute("notices", notices);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}


}
