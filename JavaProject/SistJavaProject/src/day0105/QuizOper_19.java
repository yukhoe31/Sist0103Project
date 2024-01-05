package day0105;

import java.util.Scanner;

public class QuizOper_19 {

	public static void main(String[] args) {
		/*
		 * (평가: 90점 이상은 참 잘함!!
		 * 80점 이상은 좀더 노력하세요~~
		 * 80점 미만: 불합격)
		 * 
		 * 이름을 입력하세요
		 * 손흥민
		 * 국,영,수 점수를 입력하세요.
		 * 88
		 * 99
		 * 77
		 * 
		 * ==============================
		 * [손흥민 님의 기말고사 성적]
		 * 총점: ** 점
		 * 평균: **.*점
		 * 평가: 좀 더 노력하세요~~
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		
		System.out.println("국,영,수 점수를 입력하세요");
		int kor = Integer.parseInt(sc.nextLine());
		int eng = Integer.parseInt(sc.nextLine());
		int math = Integer.parseInt(sc.nextLine());
		
		int total= kor+eng+math;
		double avg = total/3.0;
		
		String grade="불합격";
		
		if(avg>=90) {
			grade="참 잘함!";
		}else if(avg>=80) {
			grade="좀 더 노력하세요~~";
		}else {
			grade="불합격";
		}
		
		System.out.println("============================");
		System.out.println("[" +name+"님의 기말고사 성적]");
		System.out.println("총점: " +total+"점");
		System.out.printf("평균: %.1f점\n",avg);
		System.out.println("평가: " + grade);
		
	}
	
}





