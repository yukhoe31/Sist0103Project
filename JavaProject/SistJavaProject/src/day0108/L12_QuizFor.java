package day0108;

import java.util.Scanner;

public class L12_QuizFor {

	public static void main(String[] args) {
		
		System.out.println("#1. 1  2  4  5  7  8  10 (continue 활용할 것!!)");
		for(int i=1; i<=10; i++) {
			if(i%3 == 0) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println();
		
		
		System.out.println("#2. 홀수값:1 홀수값:3 홀수값:5 홀수값:7 홀수값:9");
		for(int i=1; i<=10; i++) {
			if(i%2==0) {
				System.out.print("홀수값:" + i + " ");
			}
		}
		System.out.println();
		System.out.println();
		
		
		
		System.out.println("#3. 점수를 입력후 합계를 구하는데 "
				+ "0을 입력하면 빠져나와서 합계출력: while(true)");

		Scanner sc = new Scanner(System.in);		
		int sum = 0;
		int score = 0;
		
		while(true) {
			
			System.out.print("점수 입력:");
			score = sc.nextInt();
			
			//※break문은 반복문 내에서 맨 위에 써라.
			if(score == 0) {
				break;
			}
			
			if(score<0 || score>100) {
				System.out.println("입력값이 범위를 벗어났습니다."
						+ " 재입력해주세요.");
				continue;//※잘못입력한 값은 넘어가되, 반복문 초기로 돌아간다.
			}
			sum += score;
		}
		System.out.println("합계: " + sum);
	}
}
