package day0129;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.proxy.annotation.Pre;
import oracleDb.DbConnect;

public class L02_JdbcScore {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	//1.성적 입력 메서드(이름,자바,오라클)
	public void insertSungjuk() {
		System.out.println("학생명?");
		String name = sc.nextLine();
		System.out.println("자바점수?");
		int java = Integer.parseInt(sc.nextLine());
		System.out.println("오라클점수?");
		int oracle = Integer.parseInt(sc.nextLine());

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		//아래처럼 엉망으로 넣어도 제대로 들어간다. 바인딩 순서만 잘 지키면
		String sql = "insert into sungjuk (num,oracle,name,java)"
				+ " values (seq_score.nextval,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);

			//바인딩 //?갯수만큼 모두 바인딩후 실행
			pstmt.setInt(1, oracle);
			pstmt.setString(2, name);
			pstmt.setInt(3, java);

			pstmt.execute();
			System.out.println("추가되었습니다~~");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}


	//1+.총점,평균 구하는 메서드
	public void calcTotalAverage() {
		Connection conn = db.getOracle();
		Statement stmt = null;

		String sql = "update sungjuk set total = java + oracle,"
				+ "average = (java + oracle)/2";

		try {
			stmt = conn.createStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}


	//2.전체출력 메서드
	public void writeAll() {

		//총점평균 먼저 계산후 출력
		this.calcTotalAverage();

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sungjuk order by num";

		System.out.println("[1.학생성적 출력]");
		System.out.println();
		System.out.println("번호\t이름\t자바\t오라클\t총점\t평균");
		System.out.println("------------------------------------------------");

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t"
						+ rs.getString("name") + "\t"
						+ rs.getInt("java") + "\t"
						+ rs.getInt("oracle") + "\t"
						+ rs.getInt("total") + "\t"
						+ rs.getDouble("average"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	
	//3.삭제 메서드
	public void deleteSungjuk() {
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		//시퀀스를 입력받아 "해당 데이터를 지운후 삭제되었습니다." 출력
		//만약 해당번호 없으면 "5번 학생은 존재하지 않습니다."출력
		System.out.println("삭제할 학생의 번호를 입력하시오:");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from sungjuk where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			int n = pstmt.executeUpdate();
			if(n==1) {
				System.out.println(num+"번 학생정보를 지운후 삭제되었습니다.");
			}else {//n==0
				System.out.println(num+"번 학생은 존재하지 않습니다.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}

	
	//4.수정 메서드
	public void updateSungjuk() {
		//수정할 num을 입력후 java,oracle 의 수정값을 입력받아 수정할 것.
		//num이 있을경우 "수정됨" 없을경우 "5번학생은 존재하지 않음"
		System.out.println("수정할 번호 선택:");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("수정할 자바점수 입력:");
		int java = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 오라클점수 입력:");
		int oracle = Integer.parseInt(sc.nextLine());
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "update sungjuk set java=?,oracle=? where num=?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setInt(1, java);
			pstmt.setInt(2, oracle);
			pstmt.setInt(3, num);
			
			//실행
			int n = pstmt.executeUpdate();
			
			if(n==1) {//해당 번호 학생이 존재함
				System.out.println("수정됨!!");
			}else {//해당 학생이 존재하지 않음
				System.out.println(num + "번 학생이 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

		
	}


	//0.인터페이스 메서드
	public void process() {

		while(true) {
			System.out.println("1.학생성적추가  2.학생정보전체출력 "
					+ " 3.학생정보삭제  4.학생정보수정  9.종료");

			int num = Integer.parseInt(sc.nextLine());

			switch(num) {
			case 1:
				this.insertSungjuk();
				break;
			case 2:
				this.writeAll();
				break;
			case 3:
				this.deleteSungjuk();
				break;
			case 4:
				this.updateSungjuk();
				break;	
			case 9:
				System.out.println("**성적 프로그램 종료**");
				System.exit(0);//강제종료
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
			
			System.out.println();

		}
	}

	
	//메인 메서드
	public static void main(String[] args) {

		L02_JdbcScore score = new L02_JdbcScore();

		//0.인터페이스 메서드 불러오기
		score.process();


	}

}
