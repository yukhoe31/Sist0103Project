package day0108;

import java.util.Scanner;

public class L13_Factorial {

	public static void main(String[] args) {
		// 1~10까지의 팩토리얼 구하기.
		
		int result = 1;
		
		for(int i =1; i<=10; i++) {
			result *= i;
			System.out.println(i + "! = " + result);
		}
		
		//Q. 합계를 구할 숫자를 입력시, 1부터 입력한 숫자까지의 합을 구해주세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("합계를 구할 숫자를 입력해라.");
		int num = sc.nextInt();
		int sum = 0;
		
		for(int i=1;i<=num ; i++) {
			sum += i;
		}
		System.out.println("1부터 "+num+"까지의 합 : " + sum);

	}

}
