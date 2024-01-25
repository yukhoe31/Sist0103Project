package day0125;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectTest {

	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public void connectSawon() {
		
		//아래내용 자동완성시 -> 전부 .sql 버전으로 하기.
		Connection conn = null; //초기값 없으니까 null해준다.
		java.sql.Statement stmt = null;//
		ResultSet rs = null;//
		
		String sql = "select * from sawon order by num";
		//num의 오름차순으로 사원 데이터를 가지고 오겠다.
		//sawon 테이블은 day0124에 stu계정으로 만들었으므로
		//집에서 다시 할 땐, sawon테이블부터 있는지 확인할것.
		
		try {
			conn = DriverManager.getConnection(URL, "stu", "a1234");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			//rs: 테이블 객체를 그대로 가져오는 api
			
			//여러줄을 DB에서 가져올 때는 while문을 쓴다.
			//true값을 반환...false가 되는순간 빠져나와.
			//rs.next():다음 데이터를 이동하면서 true반환.
			//더이상 데이터가 없으면 false 반환
			while(rs.next()) {
				
				//DB로부터 데이터 가져오기
				int num = rs.getInt("num");		
				//int num = rs.getInt(1);  //이렇게도 되긴함.
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int pay = rs.getInt("pay");
				
				System.out.println(num + "\t"+ name+"\t" 
				+ gender+"\t"+buseo+"\t"+pay);
			}
			
			System.out.println("오라클 드라이버 연결 성공!!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("오라클 드라이버 연결 실패!!!");
		}finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
	
	public static void main(String[] args) {
		
		ConnectTest ct = new ConnectTest();
		ct.connectSawon();
	}
}
