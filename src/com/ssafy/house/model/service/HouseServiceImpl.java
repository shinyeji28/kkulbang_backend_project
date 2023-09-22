package com.ssafy.house.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.house.model.dao.HouseDaoImpl;
import com.ssafy.house.model.dto.DongCodeDto;
import com.ssafy.house.model.dto.HouseDealDto;
import com.ssafy.house.model.dto.HouseInfoDto;


public class HouseServiceImpl implements HouseService {

	HouseDaoImpl houseDaoImpl = HouseDaoImpl.getHouseDao();
	
	// 싱글톤 객체 만들기
	private static HouseServiceImpl instance = new HouseServiceImpl();
	
	private HouseServiceImpl() {}
	
	public static HouseServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<DongCodeDto> getAreaList() throws SQLException {
		return houseDaoImpl.getAreaList();
	}
	
	@Override
	public List<DongCodeDto> dongCodeList(String dongName) throws SQLException {
		return houseDaoImpl.dongCodeList(dongName);
	}

	@Override
	public List<HouseInfoDto> searchByDongCode(String dongCode) throws SQLException {
		return houseDaoImpl.searchByDongCode(dongCode);
	}

	@Override
	public List<HouseDealDto> searchByAptNo(long aptNo, int year, int month) throws SQLException {
		return houseDaoImpl.searchByAptNo(aptNo, year, month);
	}



}
