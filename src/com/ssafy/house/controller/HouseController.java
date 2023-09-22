package com.ssafy.house.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.house.model.dto.DongCodeDto;
import com.ssafy.house.model.service.HouseServiceImpl;


@WebServlet("/house")
public class HouseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	HouseServiceImpl houseService = HouseServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "mvHouse":
				mvHouse(request,response);
				break;
			case "gugun":
				getGugunList(request,response);
				break;
			case "searchKeyword":
				
				break;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	
	}

	private void getGugunList(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException, SQLException {
		System.out.println("구군 리스트 받기");
		System.out.println(request.getAttribute("sidoCode"));
		// 구군 데이터 받아오기
		List<DongCodeDto> gugunList = houseService.getSidoList();
		
		// jackson 넘기기 
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getWriter(), gugunList);
	}

	private void mvHouse(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		System.out.println("house페이지 이동 수신");
		// 시도 데이터 받아오기
		List<DongCodeDto> sidoList = houseService.getSidoList();
		// 지역 리스트 데이터 저장
		request.setAttribute("sidoList", sidoList);
		// forwording search.jsp
		request.getRequestDispatcher("/house/search.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
