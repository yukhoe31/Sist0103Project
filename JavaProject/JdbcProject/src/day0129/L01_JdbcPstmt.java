package day0129;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracleDb.DbConnect;

public class L01_JdbcPstmt {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	//1. insert
	public void insertSangpum() {

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("type?");
		String type = sc.nextLine();
		System.out.println("상품명?");
		String sang = sc.nextLine();
		System.out.println("수량?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("단가?");
		int dan = Integer.parseInt(sc.nextLine());

		//PreparedStatement는 미완의 sql문을 작성할 수 있다.
		//변수를 ?로 표시후 나중에 바인딩 시켜주면 된다.(자유롭게 표현 가능!!)
		String sql = "insert into sales values(seq1.nextval,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);

			//?를 순서대로 바인딩한 후 업데이트
			pstmt.setString(1,type);//1번째 물음표는 type이 온다.
			pstmt.setString(2, sang);//2번째 물음표는 sang이 온다.
			pstmt.setInt(3,su);//3번째 물음표는 su이 온다.
			pstmt.setInt(4,dan);//4번째 물음표는 dan이 온다.

			//업데이트
			int n = pstmt.executeUpdate();

			if(n==1) {
				System.out.println("인서트 성공!!!");
			}else {
				System.out.println("인서트 실패!!!");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			db.dbClose(pstmt, conn);
		}

	}
	
	
	//2. select
	public void writeSangpum() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from sales order by num asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("시퀀스\t카테고리\t상품명\t수량\t단가\t입고일");
			System.out.println("----------------------------------"
					+ "------------------------------");
			
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t"
						+rs.getString("type") + "\t\t"
						+rs.getString("sangpum") + "\t"
						+rs.getInt("su") +"\t"
						+rs.getInt("dan") +"\t"
						+rs.getDate("ipgo"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	//3.delete
	public void deleteSangpum() {
		
		//삭제...시쿼스번호로 삭제
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.println("삭제할 시퀀스는?");
		int num = Integer.parseInt(sc.nextLine());
		
		//PreparedStatement는 미완의 sql문을 작성할 수 있다.
		//변수를 ?로 표시후 나중에 바인딩 시켜주면 된다.(자유롭게 표현 가능!!)
		String sql = "delete from sales where num=?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setInt(1, num);
			
			int n = pstmt.executeUpdate();
			
			if(n==1) {
				System.out.println("삭제성공!!!");
			}else {
				System.out.println("삭제실패!!!");
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//4.update
	//수정 메서드1: num을 인자로 받아서 데이터가 있으면 true, 없으면 false를 반환하는 메소드
	public boolean isOneData(String num) {
		boolean b = false;
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//num의 존재 유무만 출력하기 위한 select문
		String sql = "select * from sales where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//0.바인딩
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			//1개일 경우는 if문
			if(rs.next()) { //데이터가 있는 경우
				b = true;
			}else {
				b = false; //데이터가 없는 경우
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return b;
	}
	
	//수정메서드2: 시퀀스 입력후 수정할 데이터 수정하는 메서드
	public void updateSangpum() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.println("수정할 시퀀스 번호는?");
		String num = sc.nextLine();
		
		//여기에서 바로위의 메서드 isOneData()를 호출해서 
		//그 번호가 존재하는지붗터 확인
		if(!this.isOneData(num)) {//num데이터가 없는경우
			System.out.println("해당 번호는 존재하지 않습니다.");
			return;
			//메서드 종료(void 리턴값인 메서드에서의 return;은 종료의 의미이다.
		}
		
		System.out.println("수정할 상품명?");
		String sang = sc.nextLine();
		System.out.println("수정할 수량?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 단가?");
		int dan = Integer.parseInt(sc.nextLine());
		
		String sql = "update sales set sangpum=?,su=?,dan=? where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//4개의 ?를 순서대로 바인딩
			pstmt.setString(1, sang);
			pstmt.setInt(2, su);
			pstmt.setInt(3, dan);
			pstmt.setString(4, num);
			
			//업데이트
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	
	//5.검색 메서드
	public void searchName() {
		System.out.println("검색할 이름을 입력하세요(이름 일부):");
		String sang  = sc.nextLine();
		
		String sql = "select num,sangpum,su,dan from sales where sangpum like ?";
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%" + sang + "%");
			//위의 sql문과 합쳐지면 아래처럼 DB에게 보내진다.
			//sql = select num,sangpum,su,dan from sales where sangpum like = '%sang%';
			rs=pstmt.executeQuery();
			
			
			System.out.println("시퀀스\t상품명\t수량\t단가");
			System.out.println("-------------------"
					+ "----------------------");
			
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t"
						+rs.getString("sangpum") + "\t"
						+rs.getInt("su") +"\t"
						+rs.getInt("dan"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
	}
	
	
	
	//메인함수
	public static void main(String[] args) {
		
		L01_JdbcPstmt sales = new L01_JdbcPstmt();
		Scanner sc = new Scanner(System.in);
		int n;
		
		while(true) {
			System.out.println("**상품입고**");
			System.out.println("1.상품추가  2.상품전체출력  3.상품삭제  4.상품수정  5.검색(이름일부) 9.종료");
		
			System.out.println("선택할 메뉴는?");
			n = Integer.parseInt(sc.nextLine());
			
			if(n==1) {
				sales.insertSangpum();
			}else if(n==2) {
				sales.writeSangpum();
			}else if(n==3) {
				sales.deleteSangpum();
			}else if(n==4) {
				sales.updateSangpum();
			}else if(n==5) {
				sales.searchName();
			}else if(n==9) {
				System.out.println("프로그램 종료합니다.");
				break;
			}
			
			System.out.println();
		
		}


	}

}
