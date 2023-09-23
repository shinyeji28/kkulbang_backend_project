package com.ssafy.house.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.house.model.dto.DongCodeDto;
import com.ssafy.house.model.dto.HouseDealDto;
import com.ssafy.house.model.dto.HouseInfoDto;



public interface HouseDao {

	// 코드,시도 가져오기
	List<DongCodeDto> getSidoList() throws SQLException;
	// 코드, 구군 가져오기
	List<DongCodeDto> getGugunList(String dongCode) throws SQLException;
	// 아파트 전체 리스트 (입력을 동까지 받음)
	List<DongCodeDto> dongCodeList(String dongName) throws SQLException;
	// 동 코드로 검색
	List<HouseInfoDto> searchByDongCode(String dongCode) throws SQLException;
	// 아파트 번호로 검색
	List<HouseDealDto> searchByAptNo(long aptNo, int year, int month) throws SQLException;
	
}
