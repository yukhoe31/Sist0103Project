package day0105;

import java.util.Scanner;

public class IfReturn_16 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int score;
		
		System.out.println("점수입력(1~100)");
		score = sc.nextInt();
		
		if(score<1 || score>100) {
			System.out.println("잘못입력했습니다.");
			return;//★현재의 main함수를 종료한다.
		}else {
			System.out.println("점수: " + score);
		}
	
	}
}
