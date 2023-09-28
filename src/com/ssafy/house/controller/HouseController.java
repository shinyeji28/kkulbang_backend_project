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
import com.ssafy.house.model.dto.HouseDealDto;
import com.ssafy.house.model.dto.HouseInfoDto;
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
			case "dong":
				getDongList(request,response);
				break;
			case "aptInfo":
				getAptInfoList(request,response);
				break;
			case "deal":
				getAptDealList(request,response);
				break;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	
	}
	private void getAptDealList(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException, SQLException {
		System.out.println("아파트 거래 정보 받기");
		long aptCode = Long.parseLong(request.getParameter("aptCode"));
		System.out.println((String) request.getParameter("aptCode"));
		List<HouseDealDto> dealList = houseService.getAptDealInfo(aptCode);
		// jackson 넘기기 
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getWriter(), dealList);

	}
	private void getAptInfoList(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException, SQLException {
		System.out.println("아파트 정보 받기");
		String dongCode = (String) request.getParameter("dongCode");
		String aptName = (String) request.getParameter("aptName");
		// 동 데이터 받아오기
		List<HouseInfoDto> aptList = houseService.searchByDongCode(dongCode,aptName);
		// jackson 넘기기 
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getWriter(), aptList);
	}

	private void getDongList(HttpServletRequest request, HttpServletResponse response) throws SQLException, StreamWriteException, DatabindException, IOException {
		System.out.println("동 리스트 받기");
		String dongCode = (String) request.getParameter("dongCode");
		// 동 데이터 받아오기
		List<DongCodeDto> dongList = houseService.getDongList(dongCode);
		// jackson 넘기기 
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		mapper.writeValue(response.getWriter(), dongList);
	}

	private void getGugunList(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException, SQLException {
		System.out.println("구군 리스트 받기");
		String dongCode = (String) request.getParameter("dongCode");
		// 구군 데이터 받아오기
		List<DongCodeDto> gugunList = houseService.getGugunList(dongCode);
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
