package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import data.dto.SmartDto;
import mysql.db.DbConnect;

public class SmartDao {

	DbConnect db = new DbConnect();

	public void insertSmart(SmartDto dto) {

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into smartboard (writer,subject,content,writeday) values(?,?,?,now())";


		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());

			pstmt.execute();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	//[paging] 필수 함수 1
	//paging list
	public List<SmartDto> getList(int start,int perPage){

		List<SmartDto> list= new ArrayList<SmartDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from smartboard order by num desc limit ?,?";

		try {
			pstmt  = conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, perPage);

			rs=pstmt.executeQuery();


			while(rs.next()) {

				SmartDto dto =new SmartDto();

				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));

				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}

	//[paging] 필수 함수 2
	//전체갯수 반환

	public int getTotalCount()
	{

		int total=0;

		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select count(*) from smartboard";

		try {
			pstmt=conn.prepareStatement(sql);

			rs=pstmt.executeQuery();

			if(rs.next())
			{
				total=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

		return total;
	}


	//num번째  dto반환
	public SmartDto getData(String num)
	{
		SmartDto dto=new SmartDto();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from smartboard order by num desc limit ?,?";

		try {
			pstmt  = conn.prepareStatement(sql);

			pstmt.setString(1, num);


			rs=pstmt.executeQuery();


			while(rs.next()) {

				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

		return dto;
	}

	//readcount
	public void updateReadCount(String num) {

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "update smartboard set readcount = readcount +1 where num=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}


	}

	//maxnum.. 가장최신에 추가된글의 num값 알기
	public int getMaxNum() {

		int max=0;

		Connection conn = db.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs = null;

		String sql = "select max(num) max from smartboard";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				max= rs.getInt("max"); //rs.getInt(1) 

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return max;


	}

	//수정..writer,subject,content 수정
	public void updateSmart(SmartDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		String sql="update smartboard set writer=?,subject=?,content=? where num=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getNum());

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}



	//삭제
	public void deleteSmart(String num)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		String sql="delete from smartguest where num=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}


}
