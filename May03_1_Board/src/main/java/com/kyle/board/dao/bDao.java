package com.kyle.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kyle.board.dto.bDto;

public class bDao {

	DataSource dataSource;
	
	public bDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void write(String bName,String bTitle,String bContent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String SQL = "insert into mvc_board values(mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt!=null) {pstmt.close();}
				if (con!=null) {con.close();}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
		
	public ArrayList<bDto> list() {
		ArrayList<bDto>dtos = new ArrayList<bDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String SQL = "select bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent from mvc_board order by bGroup desc, bStep asc";
			pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				bDto dto = new bDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) {rs.close();}
				if (pstmt!=null) {pstmt.close();}
				if (con!=null) {con.close();}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return dtos;
	}
	
	public bDto contentView(String strId) {
		upHit(strId);
		bDto dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String SQL = "select * from mvc_board where bId = ?";
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, Integer.parseInt(strId));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new bDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) {rs.close();}
				if (pstmt!=null) {pstmt.close();}
				if (con!=null) {con.close();}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return dto;
	}
	
	private void upHit(String bId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String SQL = "update mvc_board set bHit = bHit+1 where bId = ?";
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, bId);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt!=null) {pstmt.close();}
				if (con!=null) {con.close();}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
}
