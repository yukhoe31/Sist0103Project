package day0109;

import java.util.Scanner;

public class L17_QuizFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		quiz1();
		System.out.println();
		quiz2();
		System.out.println();
		quiz3();

	}
	

	public static void quiz1() {

		System.out.println("quiz1.");
		
		/*
		 * Q.팩토리얼 구할 숫자 를 입력하여 해당숫자에 대한 팩토리얼 구하기
		 * 
		 * 팩토리얼 구할 숫자 입력
		 * 5
		 * 5!=120
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("팩토리얼 구할 숫자를 입력:");
		int num = sc.nextInt();
		int result=1;
		
		for(int i=1;i<=num;i++) {
			result *= i;
		}
		
		System.out.printf("%d! = %d",num,result);
		
		
	}

	public static void quiz2() {
		
		System.out.println("quiz2.");
		/*
		 * Q. 두수 x,y를 입력후 x의 y승 _for문을 이용해서 구하기오(x를 y횟수만큼 곱하는것)
		 * 
		 * 두수 입력
		 *  3  3 
		 *  3의 3승은 27입니다
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("x입력: ");
		int x = sc.nextInt();
		
	    System.out.print("y입력: ");
	    int y = sc.nextInt();
	    
	    int result = 1;
	    
	    for(int i=1;i<=y;i++) {
	    	result *= x;
	    }
	    
	    System.out.printf("%d의 %d승은 %d입니다.", x,y,result);
	    		
		
	}

	public static void quiz3() {
		System.out.println("quiz3.");
       /*
        * 1~100까지의 숫자중 짝수의 합과 홀수의  합을  출력해주세요(for)
        * 
        * 1~100 홀수합: **
        * 1~100 짝수합: **
        */
		int sum_a=0;
		int sum_b=0;
		
		for(int i=1;i<=100;i++) {
			if(i%2==0) {//짝수합
				sum_a += i;
			}else {
				sum_b += i;
			}
		}
		
		System.out.println("1~100 홀수합: "+sum_b);
		System.out.println("1~100 짝수합: "+sum_a);
		
	}

}
