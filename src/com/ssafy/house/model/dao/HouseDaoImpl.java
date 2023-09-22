package com.ssafy.house.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.ssafy.house.model.dto.DongCodeDto;
import com.ssafy.house.model.dto.HouseDealDto;
import com.ssafy.house.model.dto.HouseInfoDto;
import com.ssafy.util.DBUtil;

public class HouseDaoImpl implements HouseDao {
	
	// 싱글톤 객체 만들기
	static private HouseDaoImpl instance = new HouseDaoImpl();
	private HouseDaoImpl() {}
	public static HouseDaoImpl getHouseDao() {
		return instance;
	}

	DBUtil dbUtil = DBUtil.getInstance();
	
	public List<DongCodeDto> getSidoList() throws SQLException {
		String sql = "select distinct dongCode, sidoName\r\n" + 
				"from dongCode\r\n" + 
				"where gugunName is null;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			List<DongCodeDto> list = new ArrayList<DongCodeDto>();
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {			
				String dongCode = rs.getString("dongCode");
				String sidoName = rs.getString("sidoName");

				DongCodeDto dongCodeDto = new DongCodeDto(dongCode,sidoName,null,null);
				list.add(dongCodeDto);
			}
			return list;
		} finally {
			dbUtil.close(conn, pstmt, rs);
		}
	}	
	
	@Override
	public List<DongCodeDto> getGugunList() throws SQLException {
		String sql = "select dongCode, gugunName\r\n" + 
				"from dongCode\r\n" + 
				"where gugunName is not null and dongName is null;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			List<DongCodeDto> list = new ArrayList<DongCodeDto>();
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {			
				String dongCode = rs.getString("dongCode");
				String gugunName = rs.getString("gugunName");

				DongCodeDto dongCodeDto = new DongCodeDto(dongCode,null,gugunName,null);
				list.add(dongCodeDto);
			}
			return list;
		} finally {
			dbUtil.close(conn, pstmt, rs);
		}
	}
	
	@Override
	public List<DongCodeDto> dongCodeList(String dongName) throws SQLException {
		String sql = "select dongCode, sidoName, gugunName\r\n" + 
				"from dongcode where dongName like concat('%',?,'%');";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			List<DongCodeDto> list = new ArrayList<DongCodeDto>();
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dongName);
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				String dongCode = rs.getString("dongCode");
				String sidoName = rs.getString("sidoName");
				String gugunName = rs.getString("gugunName");

				DongCodeDto dongCodeDto = new DongCodeDto(dongCode, sidoName, gugunName, dongName);
				list.add(dongCodeDto);
			}
			return list;
		} finally {
			dbUtil.close(conn, pstmt, rs);
		}
	}

	@Override
	public List<HouseInfoDto> searchByDongCode(String dongCode) throws SQLException {
		String sql = "select * from houseinfo where dongCode = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			List<HouseInfoDto> list = new ArrayList<HouseInfoDto>();
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongCode+"");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				long aptCode = rs.getLong("aptCode");
				int buildYear = rs.getInt("buildYear");
				String roadName = rs.getString("roadName");
				String roadNameBonbun = rs.getString("roadNameBonbun");
				String roadNameBubun = rs.getString("roadNameBubun");
				String roadNameSeq = rs.getString("roadNameSeq");
				String roadNameBasementCode = rs.getString("roadNameBasementCode");
				String roadNameCode = rs.getString("roadNameCode");
				String dong = rs.getString("dong");
				String bonbun = rs.getString("bonbun");
				String bubun = rs.getString("bubun");
				String sigunguCode = rs.getString("sigunguCode");
				String eubmyundongCode = rs.getString("eubmyundongCode");
				String landCode = rs.getString("landCode");
				String apartmentName = rs.getString("apartmentName");
				String jibun = rs.getString("jibun");
				String lng = rs.getString("lng");
				String lat = rs.getString("lat");
				
				HouseInfoDto houseInfoDto = new HouseInfoDto(aptCode, buildYear, roadName, roadNameBonbun, roadNameBubun,
						roadNameSeq, roadNameBasementCode, roadNameCode, dong, bonbun,
						bubun, sigunguCode, eubmyundongCode, dongCode, landCode,
						apartmentName, jibun, lng, lat);
				list.add(houseInfoDto);
			}
			return list;
			
			
		}finally {
			dbUtil.close(conn, pstmt, rs);
		}
	}

	@Override
	public List<HouseDealDto> searchByAptNo(long aptNo, int year, int month) throws SQLException {
		
		String sql = "select *\r\n" + 
				"from housedeal\r\n" + 
				"where aptCode = ? and dealYear = ? and dealMonth = ?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			List<HouseDealDto> list = new ArrayList<>();
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,aptNo);
			pstmt.setInt(2, year);
			pstmt.setInt(3, month);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				long no = rs.getLong("no");
				String dealAmount = rs.getString("dealAmount");
				int dealDay = rs.getInt("dealDay");
				String area = rs.getString("area");
				String floor = rs.getString("floor");
				String cancelDealType = rs.getString("cancelDealType");
				HouseDealDto houseDealDto = new HouseDealDto(no, dealAmount, year, month, dealDay, area, floor, cancelDealType, aptNo);
				list.add(houseDealDto);
			}
			return list;
			
		}finally {
			dbUtil.close(conn, pstmt, rs);
		}
	}


}
