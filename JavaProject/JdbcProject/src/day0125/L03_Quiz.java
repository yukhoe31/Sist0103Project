package day0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class L03_Quiz {

	//사용할때만 아래 주석 풀기
	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	//stu계정에서 foodshop테이블 가져오기
	public void readFoodShop() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		//select로 콘솔창에 나열하기 원하는 sql쿼리 작성
		//여기서는 alias 한글로 적지 말것!!! 다운 받기 실패한다.
		String sql = "select order_num , f.fno , order_name , fname,"
				+ " to_char(price,'L999,999,999') price1, fshopname, shoploc, order_addr"
				+ " from foodshop f, jumin j"
				+ " where f.fno = j.fno"
				+ " order by order_name";
       //★위에서처럼 돈 금액을 원79,000 이렇게 표시하려면 
	   // 아래에서 price변수를 int 가 아니라 String으로 해야한다.

		try {
			//디비의 데이터 연결해서 가져오기
			conn = DriverManager.getConnection(URL,"stu","a1234");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			//리스트 제목 출력w
			System.out.println("\t[DAY0125 요기요]");
			System.out.println();
			System.out.println("주문번호\t음식번호\t주문자\t음 식 명\t\t가   격\t상호명\t\t상점위치\t주문자위치");
			System.out.println("---------------------------------------------"
					+ "----------------------------------------"
					+ "---------------------------------------");

			//가져온 데이터를 출력
			while(rs.next()) {

				String order_num = rs.getString("order_num"); //()안에는 컬럼이름을 쓰는것이다. 
				int fno = rs.getInt("fno"); //집계함수에 한해서는 컬럼명이 없으므로 alias써도 된다.
				String order_name = rs.getString("order_name");
				String fname = rs.getString("fname");
				String price = rs.getString("price1");
				String fshopname = rs.getString("fshopname");
				String shoploc = rs.getString("shoploc");
				String order_addr = rs.getString("order_addr");

				System.out.println(order_num+"\t\t"+fno+"\t\t"+order_name+"\t"
						+fname+" "+price+"\t"+fshopname+"\t"+shoploc+"\t"+order_addr);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("오라클DB연결 실패");
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

		L03_Quiz l2 = new L03_Quiz();

		l2.readFoodShop();


	}
}