package day0108;

import java.util.Scanner;

public class L03_YoonYear {

	public static void main(String[] args) {
		// **윤년의 조건
		/*
		1. 서력 기원 연수가 4로 나누어 떨어지고,(and)
		2. 100으로 나누어 떨어지지지 않거나,(or)
		3. 400으로 나누어 떨어지면
		==> 윤년
		*/
		
		//연도 입력후 평년인지, 윤년인지 출력
		Scanner sc = new Scanner(System.in);
		int year;
		
		System.out.println("입력연도");
		year = sc.nextInt();
		
		if((year%4 == 0) && (year%100 != 0) || (year%400 == 0)) {
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
				
	}

}
