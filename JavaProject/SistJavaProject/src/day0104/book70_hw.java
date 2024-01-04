package day0104;

public class book70_hw {

	public static void main(String[] args) {

		//실험단계에서 상품명, 수량, 단가를 입력한후 다음과 같이 출력하세요.
		/*
		 * 상품명: 아이폰15
		 * 수량: 2개
		 * 단가: 1200000원
		 * 총금액: 2400000원 
		 */
		
		//방법1 : args 이용
		//1.변수선언
		String name = args[0];
		int num = Integer.parseInt(args[1]);
		int price = Integer.parseInt(args[2]); 
		//2.계산
		int total = num*price;
		//3.출력
		System.out.println("상품명: "+ name);
		System.out.println("수량: "+ num);
		System.out.println("가격: "+ price);
		System.out.println("총금액: "+ total);
		
		
		//=============================
		//방법2 : Scanner class 이용
		/*
		Scanner sc = new Scanner(System.in);
		
		//1. 변수선언
		System.out.print("상품명:");
		String name = sc.next();
		System.out.print("수량:");
		String num = sc.next();
		System.out.print("단가:");
		String price = sc.next();
	
		//2. 계산
		int total = Integer.parseInt(price) * Integer.parseInt(num);
		
		
		//3. 출력
		
		System.out.println("총금액:"+total);

        */
	}

}
