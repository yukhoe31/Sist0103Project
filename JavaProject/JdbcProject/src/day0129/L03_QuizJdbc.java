package day0129;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.print.attribute.standard.PresentationDirection;

import oracleDb.DbConnect;

public class L03_QuizJdbc {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	//1.사원정보입력 메서드
	public void m1_insert() {

		System.out.println("[1.사원정보입력]");

		System.out.println("사원명:");
		String name = sc.nextLine();
		System.out.println("부서:");
		String buseo = sc.nextLine();
		System.out.println("직책:");
		String position = sc.nextLine();
		System.out.println("성별:");
		String gender = sc.nextLine();
		System.out.println("임금:");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("보너스:");
		int bonus = Integer.parseInt(sc.nextLine());


		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		String sql = "insert into sawonmember "
				+ "values (seq_smem.nextval,?,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);

			//바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, buseo);
			pstmt.setString(3, position);
			pstmt.setString(4, gender);
			pstmt.setInt(5, pay);
			pstmt.setInt(6, bonus);

			//업데이트
			int n = pstmt.executeUpdate();

			if(n==1) {
				System.out.println("성공적으로 추가되었습니다.");
			}else {
				System.out.println("추가 실패!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	//2.전체사원출력 메서드
	public void m2_select() {

		System.out.println("[2.전체사원 출력]");
		System.out.println("사원번호\t사원명\t부서\t직책"
				+ "\t성별\t임금\t보너스\t입사일");
		System.out.println("--------------------------------------"
				+ "----------------------------------------");

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawonmember order by s_no";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				System.out.println(rs.getInt("s_no") +"\t\t"
						+ rs.getString("s_name") + "\t"
						+ rs.getString("buseo") + "\t"
						+ rs.getString("gender") + "\t"
						+ rs.getString("position") + "\t"
						+ rs.getInt("pay") + "\t"
						+ rs.getInt("bonus") + "\t"
						+ rs.getDate("ipsaday"));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	//3.사원삭제 메서드
	public void m3_delete() {
		System.out.println("[3.사원 삭제]");
		System.out.println("삭제할 사원의 사원번호를 입력하세요:");
		int num = Integer.parseInt(sc.nextLine());

		Connection conn = db.getOracle();//오라클DB와 연결하기
		PreparedStatement pstmt = null;

		String sql = "delete from sawonmember where s_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);//위의 ?안에 넣을 것:num

			//지울 데이터가 존재하는지 확인용
			int n = pstmt.executeUpdate();

			if(n==1) {//있으면
				System.out.println(num +"번 사원이 삭제되었습니다.");
			}else {//없으면
				System.out.println(num +"번 사원은 존재하지 않습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	//4.사원수정 메서드
	//4-1.입력한 사원번호가 존재하는지 확인
	public boolean m4_isDataExist(int num) {//사원번호:num넣고 확인하기

		boolean flag = false;//해당 번호가 존재하지 않음이 default

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawonmember where s_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);//?안에는 파라미터값인 num이 들어간다.

			rs = pstmt.executeQuery();

			if(rs.next()) {//해당 조건(사원번호=num)에 데이터가 존재할 때
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return flag;		
	}

	//4-2.update 메서드
	public void m4_update() {

		System.out.println("[4.사원 수정]");
		System.out.println("수정할 사원의 사원번호:");
		int num = Integer.parseInt(sc.nextLine());

		//4-1.메서드 이용
		if(!this.m4_isDataExist(num)) {//해당 사원번호가 존재하지 않음
			System.out.println(num+"번 사원이 존재하지 않습니다.");
			return;//m4_update() 메서드 강제종료
		}


		System.out.println("해당 사원의 수정후 부서:");	
		String buseo = sc.nextLine();
		System.out.println("해당 사원의 수정후 직급:");	
		String position = sc.nextLine();
		System.out.println("해당 사원의 수정후 급여:");	
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("해당 사원의 수정후 보너스:");	
		int bonus = Integer.parseInt(sc.nextLine());


		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		String sql = "update sawonmember set"
				+ " buseo = ?, position = ?, pay = ?, bonus = ? where s_no = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, buseo);
			pstmt.setString(2, position);
			pstmt.setInt(3, pay);
			pstmt.setInt(4, bonus);
			pstmt.setInt(5, num);
			pstmt.execute();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}

	}

	//5.이름검색 메서드
	public void m5_select() {

		System.out.println("[5.이름 검색]");
		System.out.println("검색할 사원의 이름(일부):");
		String name = sc.nextLine();

		System.out.println("사원번호\t사원명\t부서\t직책"
				+ "\t성별\t임금\t보너스\t입사일");
		System.out.println("--------------------------------------"
				+ "----------------------------------------");


		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawonmember where s_name like ? order by s_no";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");

			rs = pstmt.executeQuery();

			while(rs.next()) {

				System.out.println(rs.getInt("s_no") +"\t\t"
						+ rs.getString("s_name") + "\t"
						+ rs.getString("buseo") + "\t"
						+ rs.getString("position") + "\t"
						+ rs.getString("gender") + "\t"
						+ rs.getInt("pay") + "\t"
						+ rs.getInt("bonus") + "\t"
						+ rs.getDate("ipsaday"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	//0.화면 출력 메서드
	public void m0_interface() {

		int num = 0;

		while(true) {
			System.out.println("[[인사관리 시스템]]");
			System.out.println("1.사원정보입력  2.전체사원출력  3.사원삭제"
					+ "  4.사원수정  5.이름검색  9.시스템종료");

			num = Integer.parseInt(sc.nextLine());

			switch(num) {
			case 1:
				this.m1_insert();
				break;
			case 2:
				this.m2_select();
				break;
			case 3:
				this.m3_delete();
				break;
			case 4:
				this.m4_update();
				break;
			case 5:
				this.m5_select();
				break;
			case 9:
				System.out.println("인사관리 시스템을 종료합니다.");
				System.exit(0);//강제종료
			default:
				System.out.println("잘못된 번호를 입력하셨습니다.");
				break;
			}

			System.out.println();
		}
	}

	//메인함수
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		L03_QuizJdbc quiz = new L03_QuizJdbc();
		quiz.m0_interface();

	}

}
