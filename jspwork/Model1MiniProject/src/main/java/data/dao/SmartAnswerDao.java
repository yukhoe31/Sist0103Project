 package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.GuestDto;
import data.dto.SmartAnswerDto;
import mysql.db.DbConnect;

public class SmartAnswerDao {
	DbConnect db=new DbConnect();
	
	public void insertSmartAnswer(SmartAnswerDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into smartanswer (num,nickname,content,writeday) values (?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNum());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getContent());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	
	//댓글목록
	public List<SmartAnswerDto> getAnswerList(String num)
	{
		List<SmartAnswerDto> list=new Vector<SmartAnswerDto>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from smartanswer where num=? order by idx";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				SmartAnswerDto dto=new SmartAnswerDto();
				
				dto.setIdx(rs.getString("idx"));
				dto.setNum(rs.getString("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
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
	
	//댓글삭제
	public void deleteSmartAnswer(String idx)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from smartanswer where idx=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//댓글 수정
		public String getSmartContent(String idx)
		{
			String content="";

			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			String sql="select content from smartanswer where idx=?";

			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, idx);
				rs=pstmt.executeQuery();

				if(rs.next())
					content=rs.getString("content");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}


			return content;
		}

		//댓글 수정
		public void updateGuest(SmartAnswerDto dto) {

			Connection conn = db.getConnection();
			PreparedStatement pstmt  = null;

			String sql = "update smartanswer set nickname=?, content=? where idx=?";


			try {
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, dto.getNickname());
				pstmt.setString(2, dto.getContent());
				pstmt.setString(3, dto.getIdx());

				pstmt.execute();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
		}
	 
	
	
	
}
