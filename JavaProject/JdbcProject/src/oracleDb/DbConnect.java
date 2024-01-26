package oracleDb;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnect {

	//url : 퀀텀DB가서 lmyDB누르고 우클릭->Properties: 주소 복붙하기
	static final String ORACLE_DB = "jdbc:oracle:thin:@localhost:1521:XE";

	//connect 
	//아래: Connection타입을 리턴해야
	public  Connection getOracle() {

		Connection conn = null;

		try {
			
			//stu계정 사용시
			//conn = DriverManager.getConnection(ORACLE_DB, "stu","a1234");
		
			//dragon계정 사용시
			conn = DriverManager.getConnection(ORACLE_DB, "dragon","a1234");
			
			//lmy계정 사용시
			//conn = DriverManager.getConnection(ORACLE_DB, "lmy","a1234");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();

			System.out.println("로칼 오라클 연결 실패!!!");

		}

		return conn;
	}

	//close메서드를 총4개 만들기
	//select만 rs(ResultSet)가 들어간다
	public void dbClose(ResultSet rs, java.sql.Statement stmt, Connection conn) {

		try {
			if(rs!=null)  rs.close();
			if(stmt!=null)  stmt.close();
			if(conn!=null)  conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	//오버로딩
	//이름 같은데 다르게 쓰임
	public void dbClose(java.sql.Statement stmt, Connection conn) {

		try {
		
			if(stmt!=null)  stmt.close();
			if(conn!=null)  conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Prepare Statement 사용1
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {

		try {
			if(rs!=null)  rs.close();
			if(pstmt!=null)  pstmt.close();
			if(conn!=null)  conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//Prepare Statement 사용2
	public void dbClose(PreparedStatement pstmt, Connection conn) {

		try {
		
			if(pstmt!=null)  pstmt.close();
			if(conn!=null)  conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
