package day0125;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class L01_ConnectTest {

	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	//stu 계정에서 sawon테이블 가져오기
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

	//stu 계정에서 shop테이블 가져오기
	public void connectShop() {

		Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;

		String sql = "select idx,c.num,sangpum,color,cnt,guipday from shop s,cart2 c where s.num=c.num\r\n";

		try {
			conn = DriverManager.getConnection(URL, "stu","a1234");
			System.out.println("오라클 성공★");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);//executeQuery를 통해서 sql문을 전달

			System.out.println("**회원님 장바구니 리스트**");
			System.out.println("주문번호\t상품번호\t상품명\t\t색상\t구입갯수\t구입날짜");
			System.out.println("-------------------------------------"
					+ "----------------------------------------------");

			while(rs.next()) {

				int idx = rs.getInt("idx");
				int num = rs.getInt("num");
				String sang = rs.getString("sangpum");
				String color = rs.getString("color");
				int cnt = rs.getInt("cnt");
				String guipday = rs.getString("guipday");

				System.out.println(idx +"\t\t"+ num +"\t\t"+
						sang +"\t"+ color +"\t"+cnt+"\t\t"+guipday);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("오라클 실패 ♣");
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


	//부서별 인원수와 평균급여를 가져오는 메서드
	public void sawonRead() {

		//연결해서 가져오기
		Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;

		//select로 나열하기 원하는 sql쿼리 작성
		String sql = "select buseo, count(*) cnt,"
				+ " round(avg(pay),0) pay from sawon group by buseo";

		try {

			conn = DriverManager.getConnection(URL, "stu", "a1234");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("\t[부서별 평균 인원및 급여구하기]");
			System.out.println();
			System.out.println("부서명\t인원수\t평균급여");	
			System.out.println("------------------------------------");

			while(rs.next()) {
				String buseo = rs.getString("buseo");
				int count = rs.getInt("cnt");
				int pay = rs.getInt("pay");

				System.out.println(buseo +"\t"+ count+"명\t"+pay +"원");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		L01_ConnectTest ct = new L01_ConnectTest();

		//stu계정 내의 sawon테이블 가져오기
		ct.connectSawon();

		System.out.println();

		//stu계정 내의 shop테이블 가져오기
		ct.connectShop();
		
		System.out.println();
		
		//stu계정 내의 sawon테이블에서 부서별 인원수와 평균급여를 가져오는 메서드
		ct.sawonRead();
	}
}
