package day0105;

import java.util.Calendar;
import java.util.Scanner;

public class QuizMyAgeInOut_02 {

	private static final int YEAR = 0;

	public static void main(String[] args) {
		/*
		 * 당신의 이름은?==>이수연
		 * 당신이 태어난 연도는?==>1988
		 * 당신이 사는 지역은?==>경기
		 * 
		 * ===============================
		 * [이수연 님의 개인정보]
		 * ===============================
		 * 이름: 이수연
		 * 출생년도: 1988
		 * 나이: **세
		 * 지역: 경기
		 */
		
		//1.import
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		//2.변수 선언 및 입력
		System.out.print("당신의 이름은?==>");
		String name = sc.nextLine();
		
		System.out.print("당신이 태어난 연도는?==>");
		int birth_year = sc.nextInt();
		sc.nextLine();//※개행문자 잡아먹힘 방지용:
		//sc.nextLine()은 키보드의 버퍼나 엔터를 먼저읽어서 없애준다.
		//또다른 방법으로는 아래처럼 한줄로 적는 방법이 있다.
		//int birth_year = Integer.parseInt(sc.nextLine());
		//nextLine():String으로 받아서 --> int로 변경하기.
		
		System.out.print("당신이 사는 지역은?==>");
		String local = sc.nextLine();
		
		//3.계산
		int age = cal.get(cal.YEAR) - birth_year;
		
		//4.최종출력
		System.out.println();
		System.out.println("=======================");
		System.out.println("[이수연 님의 개인정보]");
		System.out.println("=======================");
		
		System.out.println("이름: "+ name);
		System.out.println("출생년도: " + birth_year);
		System.out.println("나이: " + age +"세");
		System.out.println("지역: " + local);
		
	}

}
