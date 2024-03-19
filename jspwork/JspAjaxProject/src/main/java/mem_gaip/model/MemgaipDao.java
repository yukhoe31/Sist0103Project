package mem_gaip.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql.db.DbConnect;
import quizshop.model.QuizShopDto;
import simpleboard.model.SimpleBoardDto;
import uploadboard.data.UploadBoardDto;

public class MemgaipDao {


	DbConnect db = new DbConnect();

	//아이디가 존재하면 true를 리턴해주는 
	public boolean isIdCheck(String m_id) {

		boolean b = false;//있을경우에만 true로 변경
		Connection conn  = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from memgaip where m_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs= pstmt.executeQuery();

			if(rs.next()) {
				b=true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}


		return b;
	}



	//insert 메서드
	public void insertMemgaip(MemgaipDto dto) {

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into memgaip values (null,?,?,?,?,?,now())";


		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getM_id());
			pstmt.setString(2, dto.getM_pass());
			pstmt.setString(3, dto.getM_name());
			pstmt.setString(4, dto.getM_hp());
			pstmt.setString(5, dto.getM_photo());

			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}



	//전체출력
	public List<MemgaipDto> getMemList() {
		List<MemgaipDto> list = new ArrayList<MemgaipDto>();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from memgaip order by m_num";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemgaipDto dto = new MemgaipDto();

				dto.setM_num(rs.getString("m_num"));
				dto.setM_id(rs.getString("m_id"));
				dto.setM_hp(rs.getString("m_hp"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_photo(rs.getString("m_photo"));
				dto.setGaipday(rs.getTimestamp("gaipday"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}


	//delete 메서드
	public void deleteMember(String m_num)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		String sql="delete from memgaip where m_num=?";

		try {
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, m_num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	//num에 대한 dto반환
	public MemgaipDto getOneMember(String m_num)
	{
		MemgaipDto dto=new MemgaipDto();

		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from memgaip where m_num=?";

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m_num);
			rs=pstmt.executeQuery();

			if(rs.next())
			{
				dto.setM_num(rs.getString("m_num"));
				dto.setM_id(rs.getString("m_id"));
				dto.setM_hp(rs.getString("m_hp"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_photo(rs.getString("m_photo"));
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


	//update 메서드 : 내가 한 것
	public void updateMember(MemgaipDto dto)
	{
		//subject,content,imagname만수정
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		String sql="update memgaip set m_name=?,m_pass=?, m_hp=?,m_photo=? where m_num=?";

		try {
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getM_name());
			pstmt.setString(2, dto.getM_pass());
			pstmt.setString(3, dto.getM_hp());
			pstmt.setString(4, dto.getM_photo());
			pstmt.setString(5, dto.getM_num());

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}
	
	//update 메서드 : 선생님이 하신것
	public void updateMember2(MemgaipDto dto)
	{
		//subject,content,imagname만수정
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		String sql="update memgaip set m_name=?, m_hp=?,m_photo=? where m_num=?";

		try {
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getM_name());
			//pstmt.setString(2, dto.getM_pass());
			pstmt.setString(2, dto.getM_hp());
			pstmt.setString(3, dto.getM_photo());
			pstmt.setString(4, dto.getM_num());

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}



	//비밀번호 맞추기
	public boolean isEqualPass(String m_num, String m_pass) {

		boolean check = false;

		Connection conn = db.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs = null;

		String sql = "select count(*) from memgaip where m_num=? and m_pass=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m_num);
			pstmt.setString(2, m_pass);

			rs=pstmt.executeQuery();

			if(rs.next()) {

				if(rs.getInt(1)==1) {
					check = true;		
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

		return check;
	}





}
