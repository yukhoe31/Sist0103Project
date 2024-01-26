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
import java.sql.Statement;
import java.util.Scanner;
import oracleDb.DbConnect;





public class L03_QuizStuInfo {
	
	DbConnect db = new DbConnect();
	
	//1.학생정보입력 메서드
	public void m1_insert() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**1.학생정보입력**");
		System.out.println("학생명?");
		String name = sc.nextLine();
		System.out.println("성별?");
		String gender = sc.nextLine();
		System.out.println("나이?");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("연락처?");
		String hp = sc.nextLine();
		
		
		//sql
		String sql = "insert into stuinfo values (seq_info.nextval,'"+name+"','"+gender+"','"+age+"',"+hp+")";
		System.out.println(sql);
		
		//db연결
		Connection conn = null;//sql문 객체 전송에 필요한 API
		Statement stmt = null;
		
		conn = db.getOracle();
		
		stmt = conn.createStatement();
		
		
	}
	
	//2.정보출력 메서드
	public void m2_select() {
		
	}
	
	//3.정보삭제 메서드
	public void m3_delete() {
		
	}
	
	//4.학생정보수정 메서드
	public void m4_update() {
		
	}
	
	//5.학생검색 메서드
	public void m5_select() {
		
	}

	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//생성
		L03_QuizStuInfo quiz = new L03_QuizStuInfo();
			
		//1.2.3.4,5,9 선택지 중 하나 번호 고르기할때 쓰는 용도의 스캐너
		Scanner sc = new Scanner(System.in);
		int n;
		
		
		while(true) {
			
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
				System.out.println("종료합니다.");
				break;
			default:
				break;
			}
			
			
			
			System.out.println();
			
		}
		
	}

	}

}
