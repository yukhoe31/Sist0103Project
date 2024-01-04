package day0104;

import java.util.Scanner;

public class KeyBoardIn_15 {

	public static void main(String[] args) {
		// 이름, 국, 영, 수 점수를 입력하고 결과출력해보기
		
		Scanner sc = new Scanner(System.in);
		
		//변수는 미리 선언하거나 입력할 때 주어도된다.
		String stuName;
		int kor, eng, math;
		int total;
		double avg;
		
		//입력
		System.out.println("학생명?");
		stuName=sc.nextLine();
		System.out.println("국 영 수 점수를 입력하시오:");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		//계산
		total = kor + eng + math;
		avg = (double)total/3; // 또는 total/3.0; 으로 작성
		
		//최종출력
		System.out.println("==========================");
		System.out.println("학생명: " + stuName);
		System.out.println("국어: " + kor);
		System.out.println("영어: " + eng);
		System.out.println("수학: " + math);
		System.out.println("합계: " + total);
		System.out.println("평균: " + avg);
		
	}

}

