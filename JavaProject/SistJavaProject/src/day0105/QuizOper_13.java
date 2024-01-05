package day0105;
import java.util.Scanner;

public class QuizOper_13 {
	public static void main(String[] args) {
		// 3개의 숫자를 입력하여 가장 큰 값 max값을 구하라.
		//if문 && 삼항연산자로도 구해보세요.
		/*
		 * 3개의 숫자를 입력하시요
		 * 3 
		 * 5 
		 * 4
		 * **if**
		 * max = 5
		 * **삼항연산자**
		 * max = 5
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("3개의 숫자를 입력하세요");
		int a = sc.nextInt();
		sc.nextLine();
		int b = sc.nextInt();
		sc.nextLine();		
		int c = sc.nextInt();
		sc.nextLine();
		
		int max = 0;
		
		//if
		if(a>=b && a>=c) {
			max = a;
		}else if(b>=a && b>=c) {
			max = b;
		}else {
			max = c;
		}
		
		System.out.println("max = " + max);
		
		//삼항연산자
		int max2 = (a>=b && a>=c)?a:
			       (b>=a && b>=c)?b:c;
		
		System.out.println("max = " + max2);

	}

}
