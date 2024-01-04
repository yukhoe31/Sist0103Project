package day0104;

import java.util.Scanner;

public class QuizKeyBoardIn_16 {

	public static void main(String[] args) {
	
		
		//1.import
		Scanner sc = new Scanner(System.in);
		
		//2.변수선언 + 입력
		System.out.print("상품명을 입력하세요. ==>");
		String name = sc.nextLine(); //String 받기 위해서 무조건 nextLine()사용
		
		System.out.print("가격은 얼마입니까? ==>");
	    int price = sc.nextInt();
	    
	    System.out.print("수량은 몇개입니까? ==>");
	    int num = sc.nextInt();
	    
	    //3.계산
	    int total = price * num;
	    
	    //4.최종출력
	    System.out.println();
	    System.out.println("\t[상품입고]");
	    System.out.println("===================");
	    System.out.println("입고 상품명: " + name);
	    System.out.println("수량: "+ num +"개");
	    System.out.println("가격: " + price + "원");
	    System.out.println("===================");
	    System.out.println("총가격: " + total+"원");
	    
		/*
		 * 상품명을 입력하세요. ==> 아이폰15
		 * 가격은 얼마입니까? ==> 1200000
		 * 수량은 몇개입니까? ==> 5
		 * 
		 * 	       [상품입고]
		 * ======================
		 * 입고 상품명: 아이폰15 
		 * 수량: 5개
		 * 가격: 1200000원
		 * ======================
		 * 총가격: 6000000원
		 */
	    
	    

	}

}
