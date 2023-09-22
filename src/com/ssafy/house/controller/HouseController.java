package com.ssafy.house.controller;

import java.awt.geom.Area;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			case "searchKeyword":
				
				break;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	
	}

	private void mvHouse(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("house페이지 이동 수신");
		// 시, 구, 동 데이터 받아오기
		List<DongCodeDto> areaList = houseService.getAreaList();
		// 지역 리스트 데이터 저장
		request.setAttribute("areaList", areaList);
		// forword
//		request.getRequestDispatcher("/")
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
