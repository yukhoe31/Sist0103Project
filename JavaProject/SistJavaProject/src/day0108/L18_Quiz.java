package day0108;

import java.util.Scanner;

public class L18_Quiz {
	
	public static void main(String[] args) {
		quiz_1();
		quiz_2();
		System.out.println();
		quiz_3();
	}
	
	public static void quiz_1() {
		
		System.out.println("[문제1]");
		//Q. 반복해서 숫자를 입력하여 
		//양수의 갯수와 음수의 갯수를 구하시오.(0입력시 종료)
		/*
		 * 숫자입력: 6
		 * 숫자입력: -10
		 * 88
		 * 120
		 * -130
		 * 0
		 * 양수의 갯수: 3개
		 * 음수의 갯수: 2개 
		 */
		
		//1.입력받기
		Scanner sc = new Scanner(System.in);
		int num;
		int count_plus=0;//양수 갯수
		int count_minus=0;
		
		while(true) {
			System.out.print("숫자입력:");
			num = sc.nextInt();
			
			if(num == 0) {
				break;
			}else if(num>0) {//양수
				count_plus++;
			}else {//음수
				count_minus++;
			}
		}
		//
		System.out.println("양수의 갯수: "+count_plus+"개");
		System.out.println("음수의 갯수: "+count_minus+"개");
	
	}
	
	public static void quiz_2() {
		
		System.out.println("[문제2]");
		
		//반복해서 정수를 입력하고(1~100)
		//0을 입력시 빠져나와 총 갯수와 합계, 평균을 구하시요.
		
		Scanner sc = new Scanner(System.in);
		int num;
		int count=0;
		int sum=0;
		double avg=0;
		
		while(true) {
			System.out.print("정수입력(1~100):");
			num = sc.nextInt();
			
			
			if(num == 0) {
				break;
			}else if(num>100 || num<0){
				System.out.println("1이상 100이하의 정수를 입력해주세요.");
				continue;
			}
			
			count++;
			sum += num;
		}
		
		avg = (double)sum/count;
		
		System.out.println("총 갯수: "+count+"개");
		System.out.println("합계: "+sum);
		System.out.printf("평균: %.2f",avg);
		
	}
	
	public static void quiz_3() {
		
		System.out.println("[문제3]");
		//Q. 반복해서 점수를 입력하고 (1~100)
		//0을 입력시 빠져나와 갯수와 합계와 평균을 구하시요.
		//범위에 맞지않는 점수는 횟수에서 제외되어야 한다.
		
		Scanner sc = new Scanner(System.in);
		int num;
		int count=0;
		int sum=0;
		double avg=0;
		
		while(true) {
			System.out.print("정수입력(1~100):");
			num = sc.nextInt();
			
			if(num == 0) {
				break;
			}else if(num>100 || num<0){
				System.out.println("1이상 100이하의 정수를 입력해주세요.");
				continue;
			}
			
			count++;
			sum += num;
		}
		
		avg = (double)sum/count;
		
		System.out.println("총 갯수: "+count+"개");
		System.out.println("합계: "+sum);
		System.out.printf("평균: %.2f",avg);
		
	}
	
}
