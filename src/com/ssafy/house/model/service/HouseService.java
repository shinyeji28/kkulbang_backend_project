package com.ssafy.house.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.house.model.dto.DongCodeDto;
import com.ssafy.house.model.dto.HouseDealDto;
import com.ssafy.house.model.dto.HouseInfoDto;

public interface HouseService {
	
	List<DongCodeDto> getSidoList() throws SQLException;
	
	List<DongCodeDto> getGugunList(String dongCode) throws SQLException;
		
	List<DongCodeDto> getDongList(String donCode) throws SQLException;

	List<HouseInfoDto> searchByDongCode(String dongCode) throws SQLException;

	List<HouseDealDto> searchByAptNo(long aptNo, int year, int month) throws SQLException;
	
	List<HouseDealDto> getAptDealInfo(long aptCode) throws SQLException;
}
