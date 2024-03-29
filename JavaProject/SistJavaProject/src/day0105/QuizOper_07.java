package day0105;

import java.util.Scanner;

public class QuizOper_07 {

	public static void main(String[] args) {
		// 여러분이 받은 알바비를 입력한 후,
		// 만원, 천원, 백원, 십원, 일원의 갯수를 출력해라.
		
		/*
		 * 알바비는?  568712
		 * 
		 * 만원: 56 -> 568712 / 10000 = 56
		 * 천원: 8  -> 568712 % 10000 = 8712 -> 8712/1000 = 8
		 * 백원: 7  -> 568712 % 1000 = 712 -> 712/100 = 7
		 * 십원: 1  -> 568712 % 100 = 12 -> 12/100 = 1
		 * 일원: 2  -> 568712 % 10 = 2 -> 2/10 = 2
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("알바비는? ");
		int money = sc.nextInt();
		
		System.out.println("만원:"+ money/10000);
		
		System.out.println("천원:"+ (money%10000)/1000);
			
		System.out.println("백원:"+ (money%1000)/100);
		
		System.out.println("십원:"+ (money%100)/10);
		
		System.out.println("일원: "+ (money%10)/1);		
	}
}
