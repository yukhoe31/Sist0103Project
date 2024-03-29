package day0105;

import java.util.Scanner;

public class IfTest_10 {

	public static void main(String[] args) {
		// 숫자 하나를 입력하여 결과를 출력하세요.
		/*
		 * 당신이 좋아하는 숫자는?
		 * 99
		 * 
		 * 그 숫자는 홀수입니다.
		 * 다음에 만나요.
		 */
		
		//방법1
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신이 좋아하는 숫자는?");
		int num = sc.nextInt();
		
		
		if(num%2 == 0) {
			System.out.println("그 숫자는 짝수입니다.");
		}else {
			System.out.println("그 숫자는 홀수입니다.");
		}
		
		System.out.println("다음에 만나요.");
				
		//방법2
		//삼항연산자(조건이 참/거짓으로 나뉠때 사용된다.)
		//구하려는 값 = 수식1? "참":"거짓"
		
		String a;
		a = num%2==0? "짝수":"홀수";
		
		System.out.println("그 숫자는 " + a +"입니다.");
		
		//방법3
		//switch문
		System.out.println("***switch문***");
		
		switch(num%2) {
			case 0:
				System.out.println("짝수");
				break;
			case 1:
				System.out.println("홀수");
				break;
		}
		
		

	}

}
