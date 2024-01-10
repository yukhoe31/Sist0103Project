package day0110;

public class L03_ArraysChange {

	public static void main(String[] args) {
		
		//순서바꾸기 연습
		
		int a=10, b=20;
		System.out.println("a= "+a +", b= "+b );
		
		int temp =a;//임시 저장소인 temp변수를 만들기.
		a=b;
		b=temp;
		System.out.println("a= "+a +", b= "+b );
		
		int [] n = {5,8,4};
		
		for(int s:n) {//배열 n 내용물을 차례대로
			System.out.print(s+ "  ");
		}
		
		System.out.println("0번이랑 2번을 교환 수 출력");
		int temp2 = n[0];
		n[0] = n[2];
		n[2]= temp2;
		
		for(int s:n) {
			System.out.print(s+"  ");
		}
	}
}
