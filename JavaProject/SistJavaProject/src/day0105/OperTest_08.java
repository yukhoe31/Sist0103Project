package day0105;

import java.util.Scanner;

public class OperTest_08 {

	public static void main(String[] args) {
		//신체검사를 하는데 이름과 키, 몸무게 입력화면
		//표준몸무게 출력해보기(키-100)*0.9 ..소수점 한자리 출력
		/*
		 * 당신의 이름? 이효리
		 * 키? 165
		 * 몸무게? 55
		 * 
		 * =====================================
		 * 이효리님의 표준몸무게는 55키로 입니다.
		 */
		
        Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 이름?");
		String name = sc.nextLine();
		
		System.out.print("키?");
		int height = sc.nextInt();
		sc.nextLine();
		
		System.out.print("몸무게? ");
		double weight = sc.nextDouble();
		sc.nextLine();
		
		double pwo_weight = ((height - 100)*0.9);
		System.out.println(pwo_weight);
		
		System.out.println("===============================");
		System.out.printf("%s님의 권장 표준몸무게는 %.1f입니다.",name,pwo_weight);

	}

}
