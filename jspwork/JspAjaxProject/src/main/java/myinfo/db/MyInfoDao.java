package myinfo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.db.DbConnect;

public class MyInfoDao {

	DbConnect db = new DbConnect();

	public void insertMyInfo(MyInfoDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		String sql="insert into myinfo values (null,?,?,?,?,now())";

		try {
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getHp());
			pstmt.setString(3, dto.getBlood());
			pstmt.setString(4, dto.getBirth());

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	public List<MyInfoDto> getAllInfos(){
		List<MyInfoDto> list=new ArrayList<MyInfoDto>();

		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from myinfo order by num desc";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				MyInfoDto dto = new MyInfoDto();

				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setHp(rs.getString("hp"));
				dto.setBlood(rs.getString("blood"));
				dto.setBirth(rs.getString("birth"));
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
}
