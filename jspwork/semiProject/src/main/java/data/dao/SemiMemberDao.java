package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.dto.SemiMemberDto;
import mysql.db.DbConnect;

public class SemiMemberDao {
	

	DbConnect db = new DbConnect();


	//아이디체크
	
	//아이디체크
		public int isIdCheck(String id) {

			int isid=0;

			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			System.out.println(id);
			String sql = "select count(*) from semimember where id=?";

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

	
	
	
	//아이디에 대한 dto(회원정보전부) 반환
		public SemiMemberDto getMemberById(String id) {
			SemiMemberDto dto = new SemiMemberDto();

			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs  = null;

			String sql = "select * from semimember where id=?";

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


	//insert:회원가입
	public void insertMember(SemiMemberDto dto) {

		Connection conn  = db.getConnection();
		PreparedStatement pstmt =null;

		String sql ="insert into semimember values(null,?,?,?,?,?,?,now())";


		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
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
	

}
