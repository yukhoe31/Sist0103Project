package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import data.dto.MemberDto;
import mysql.db.DbConnect;

public class MemberDao {

	DbConnect db = new DbConnect();


	//아이디체크
	public int isIdCheck(String id) {

		int isid=0;

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from member where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) {

				 if(rs.getInt(1)==1)
					 isid=1;
				

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}



		return isid;

	}

	
	//insert
	public void insertMember(MemberDto dto) {
		
		Connection conn  = db.getConnection();
		PreparedStatement pstmt =null;
		
		String sql ="insert into member values(null,?,?,?,?,?,?,now())";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPass());
			pstmt.setString(4, dto.getHp());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getEmail());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
	
	//num번째  dto반환
	  public MemberDto getOneData(String num)
	  {
		  MemberDto dto=new MemberDto();
		  
		  Connection conn=db.getConnection();
		  PreparedStatement pstmt=null;
		  ResultSet rs=null;
		  
		  String sql="select * from member where num=?";
		  
		  try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setHp(rs.getString("hp"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				dto.setGaipday(rs.getTimestamp("gaipday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		  
		  
		  return dto;
	  }
	
	  public MemberDto getMemberById(String id) {
		  MemberDto dto = new MemberDto();
		  
		  Connection conn = db.getConnection();
		  PreparedStatement pstmt = null;
		  ResultSet rs  = null;
		  
		  String sql = "select * from member where = id?";
		  
		  try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setHp(rs.getString("hp"));
				dto.setAddr(rs.getString("addr"));
				dto.setEmail(rs.getString("email"));
				dto.setGaipday(rs.getTimestamp("gaipday"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

		  return dto;
	  }

}
