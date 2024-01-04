package day0104;

import java.util.Scanner;

public class book70_hw_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("x값 입력: ");
		int x = sc.nextInt();
		
		System.out.print("y값 입력: ");
		int y = sc.nextInt();
		
		int result = x+y;
		
		System.out.println("x + y = " + result);
		
		System.out.println();
		
		while(true) {
			
			System.out.print("입력 문자열: ");
			String input = sc.next();
			
			//만약 입력 문자열이 "q"라면 출력 문자열 없이 반복문을 탈출하라.
			if(input.equals("q")) {
				break;
			}
			
			System.out.println("출력 문자열: " + input);		
			System.out.println();
		}
		
		//반복문 탈출 후
		System.out.println("종료");
	}
}
