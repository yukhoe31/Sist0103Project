package day0112;

import java.util.Scanner;

class Menu{
	
	private String name;
	private int price;

	private static int count=0;

	//명시적 생성자(2개)
	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}

	//메뉴 보여주는 메서드
	public void showMenu() {
		count++;
		System.out.println("[메뉴_"+ count +"]");
		System.out.println("음식명: " + name);
		System.out.println("가격: " + price);
		System.out.println("--------------------------");

	}


}


public class L01_ArrReview {

	public static void showMenu() {
		System.out.println("메뉴명: ");
		System.out.println("가격:");
	}

	public static void main(String[] args) {

		//방법1: 배열없이 사용
		/*
		Menu m1 = new Menu("마르게리타 피자",12000);
		m1.showMenu();

		Menu m2 = new Menu("까르보나라 스파게티",15000);
		m2.showMenu();

		Menu m3 = new Menu("리코타 샐러드",9000);
		m3.showMenu();
		 */


		//방법2: 배열 사용
		Menu [] me = new Menu [3];

		me[0] = new Menu("마르게리타 피자",12000);
		me[1] = new Menu("까르보나라 스파게티",15000);
		me[2] = new Menu("리코타 샐러드",9000);

		//방법2-1:for문
		/*
		for(int i=0;i<me.length;i++) {

			me[i].showMenu();
		}
	    */
		
		//또는 아래처럼도 가능하다.
		//방법2-2:for-each문
		for(Menu m:me) {

			m.showMenu();
		}
	}

}
