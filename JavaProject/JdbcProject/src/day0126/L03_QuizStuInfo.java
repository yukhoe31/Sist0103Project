/*
Q. 오늘 공부하신 내용 보시면서 복습겸 JDBC연습해 보세요

 시퀀스: seq_info
테이블명: stuinfo (학생정보)

    시퀀스 : s_no  : 정수형  기본키
    학생명: s_name 문자열
    성별: s_gender  문자열
    나이: s_age  정수
    연락처: s_hp  문자열
    가입일:  gaipday  :날짜형  현재날짜 들어가게…

==================================================
클래스명:  QuizStuInfo

메인에서 처리할것
1.학생정보입력  2.정보출력   3.정보삭제    4.학생정보 수정   5.학생검색   9.종료

<메소드>

1.학생정보입력시

학생명?
성별?
나이?
연락처? 
콘솙창에 각각 입력하여 insert확인한다

아직 조회는 안되므로 db로 가서 확인할것!!!!

2. 학생전체정보 출력

db와 동일하게 테이블 형태로 출력할것!!!

3.정보삭제

삭제할 시퀀스는?
 번호를 쓰면 삭제됨 표시되게 할것
조회시 삭제되었는지 확인

4. 정보수정
수정할 시퀀스는?
시퀀스 존재시  학생명,성별,나이 ,연락처 수정하도록 하세요

5. 학생검색

이 라고 쓰면  이수연,이영자 등등이 검색됩니다
영자 라고 쓰면  이영자  김영자 신영자 등등의 정보가 검색됩니다

즉 입력한글이 포함되도록 검색해보세요
검색해서 2번같은 모양이 되면 됩니다

 */


package day0126;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import oracleDb.DbConnect;


public class L03_QuizStuInfo {

	DbConnect db = new DbConnect();

	//1.학생정보입력 메서드
	public void m1_insert() {

		Scanner sc = new Scanner(System.in);

		System.out.println("[1.학생정보입력]");

		System.out.println("학생명?");
		String name = sc.nextLine();
		System.out.println("성별?");
		String gender = sc.nextLine();
		System.out.println("나이?");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("연락처?");
		String hp = sc.nextLine();


		//sql
		//원래 자바의 문자열에는 큰따옴표가 들어간다.
		//근데 sql과 합쳐지면서 작은따옴표까지 같이 들어간다.
		//name,gender,hp는 모두 String이라 작은따옴표도 필요하지만,
		//age는 정수라서 작은따옴표 없이 써도 된다.
		String sql = "insert into stuinfo values (seq_info.nextval,'"
		              +name+"','"+gender+"',"+age+",'"+hp+"', sysdate)";
		System.out.println(sql);

		//db연결
		Connection conn = null;//sql문 객체 전송에 필요한 API
		Statement stmt = null;

		conn = db.getOracle();

		try {
			stmt = conn.createStatement();

			//위에서 쓴 sql문 실행하기(execute)
			stmt.execute(sql);
			System.out.println("**데이터 추가됨**");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}

	}

	//2.정보출력 메서드
	public void m2_select() {
		
		System.out.println("[2.학생 전체 정보 출력]");
		System.out.println("시퀀스\t학생명\t성별\t나이\t연락처\t\t가입일");
		System.out.println("-------------------------------"
				+ "----------------------------------------");
		
		//사용할 sql문:select
		String sql = "select * from stuinfo order by s_no";
		
		
		//select이므로 db시리즈 셋다
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = db.getOracle();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//데이터를 while문으로 출력해주라
			while(rs.next()) {
				System.out.println(rs.getInt("s_no")
						+"\t"+ rs.getString("s_name")
						+"\t"+ rs.getString("s_gender")
						+"\t"+ rs.getInt("s_age")
						+"\t"+ rs.getString("s_hp")
						+"\t"+ rs.getString("gaipday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}

	//3.정보삭제 메서드
	public void m3_delete() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[3.정보 삭제]");
		System.out.println("삭제할 시퀀스는?");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from stuinfo where s_no =" +num;
		//어떤 delete문 썼는지 보여주고 싶으면 아래 내용 쓰기
		System.out.println(sql);
		
		//select문 아니니까 rs불필요
		Connection conn = null;
		Statement stmt = null;		
		
		conn = db.getOracle();
		
		try {
			stmt = conn.createStatement();
			//sql문을 실행할것
			int a = stmt.executeUpdate(sql);
	        //executeUpdate()는 정수를 반환한다.(0 or 1)
			//그래서 정수a에 이것을 넣어서
			//아래 if문에서 사용하는 것이다.
			
			//없는 번호 입력시 삭제되지 않으므로
			//시스템상 0이 반환된다.
			if(a==0) {
				System.out.println("없는 데이터 번호입니다.");
			}else {//1이 반환된다(true)
				System.out.println("**성공적으로 삭제되었습니다.**");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}

	
	//3.5 해당하는 데이터가 없을때 알아내는 메서드
	public boolean getOneDate(String num) {
		
		boolean flag = false;
		
		String sql = "select * from stuinfo where s_no=" + num;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = db.getOracle();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//한개만 조회할경우는 if문
			if(rs.next()) {//데이터가 있는경우
				flag = true;
			}else {
				flag = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}

		
		return flag;
		
		
	}
	
	
	//4.학생정보수정 메서드
	public void m4_update() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[4.정보 수정]");
		System.out.println("수정할 시퀀스는?");
		String num = sc.nextLine();
		
		//해당 입력한 시퀀스가 존재하는지부터 확인한다.
		if(!this.getOneDate(num)) {
			System.out.println("해당번호는 존재하지 않습니다.");
			return;
		}
		
		//bonus:해당 시퀀스의 현재 상태 출력
		//System.out.println("해당 시퀀스의 현재상태는...");
		
		
		//해당 시퀀스가 존재한다면...
		System.out.println("수정할 학생명으로 변경해주세요.");
		String name = sc.nextLine();
		System.out.println("수정할 성별로 변경해주세요.");
		String gender = sc.nextLine();
		System.out.println("수정할 나이로 변경해주세요.");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 연락처로 변경해주세요.");
		String hp = sc.nextLine();
		
		//입력할 sql문
		String sql = "update stuinfo set s_name='"+name+"',s_gender='"+gender+
				"',s_age="+age +",s_hp='"+hp+"' where s_no=" +num;
		
		//해당 sql문이 어떤지 보여주려는 용도의 문장
		System.out.println(sql);		
		
		//DB연결(select가 아니므로 rs불필요)
		Connection conn = null;
		Statement stmt = null;
		
		conn = db.getOracle();
		
		try {
			stmt = conn.createStatement();
			
			int a = stmt.executeUpdate(sql);
			
			if(a==0) {
				System.out.println("수정할 데이터가 존재하지 않습니다."); 
			}else {
				System.out.println("**수정되었습니다.**");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	//5.학생검색 메서드
	public void m5_select() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[5.학생 검색]");
		System.out.println("검색할 학생 이름?");
		String input = sc.nextLine();
		
		String sql = "select * from stuinfo where s_name LIKE '%"+input+"%' order by s_no";
		//sql문 내용확인을 위한 출력문
		//System.out.println(sql);
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = db.getOracle();
		
		System.out.println("시퀀스\t학생명\t성별\t나이\t연락처\t\t가입일");
		System.out.println("-------------------------------"
				+ "----------------------------------------");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt("s_no")
						+"\t"+ rs.getString("s_name")
						+"\t"+ rs.getString("s_gender")
						+"\t"+ rs.getInt("s_age")
						+"\t"+ rs.getString("s_hp")
						+"\t"+ rs.getString("gaipday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//생성
		L03_QuizStuInfo quiz = new L03_QuizStuInfo();

		//1.2.3.4,5,9 선택지 중 하나 번호 고르기할때 쓰는 용도의 스캐너
		Scanner sc = new Scanner(System.in);
		int n;

		boolean banban = true;
		while(banban) {

			System.out.println("**hello db 연습**");
			System.out.println("1.학생정보입력  2.정보출력   3.정보삭제    4.학생정보 수정   5.학생검색   9.종료");
								//insert         select       delete        update           select
			n=Integer.parseInt(sc.nextLine());

			switch(n) {
			case 1:
				quiz.m1_insert();
				break;
			case 2:
				quiz.m2_select();
				break;
			case 3:
				quiz.m3_delete();
				break;
			case 4:
				quiz.m4_update();
				break;
			case 5:
				quiz.m5_select();
				break;
			case 9:
				System.out.println("시스템을 종료합니다.");
				banban = false;
				break;
			default:
				break;
			}
			
			System.out.println();

		}

	}

}


