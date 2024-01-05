package day0105;

import java.util.Scanner;

public class OperTest_04 {

	public static void main(String[] args) {
		
		//두 수를 입력해서 산술연산자를 이용해 출력해보자.
		//+, -, *, /, %
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 수 입력해주세요:");
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		
		int hap = a + b;
		int ppe = a-b;
		int gop = a*b;
		float nanu = (float)a/b;
		int namu = a%b;

		System.out.println("[산술연산자결과]");
		System.out.println("더하기: "+hap);
		System.out.println("빼기: "+ppe);
		System.out.println("곱하기: "+gop);
		System.out.println("나누기: "+nanu);
		System.out.println("나머지값: "+namu);
		
		/*
		 * 두 수 입력해주세요.
		 * 6
		 * 2
		 * 
		 * [산술연산자결과]
		 * 더하기: 8
		 * 빼기: 4
		 * 곱하기: 12
		 * 나누기: 3
		 * 나머지값: 0
		 */
		
	}

}
