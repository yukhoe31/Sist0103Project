package day0111;

class Apple{

	//디폴트 생성자
	public Apple() {
		System.out.println("Apple 디폴트 생성자");

	}
}

class Banana{

	//명시적 생성자
	public Banana(String str) {
		System.out.println("생성자 호출: " +str);

	}
}

class Orange{
	
	//생성자 오버로딩이 가능하다.
	public Orange() {
		System.out.println("Orange의 디폴트 생성자호출");
	}
	public Orange(String str) {
		System.out.println("Orange의 2번째 생성자: "+ str);
	}
	public Orange(int n) {
		this(); //기본생성자를 호출, 반드시 첫줄이어야 함.
		//this()안에 아무것도 없다-> 디폴트 생성자 호출
		//this("홍길동")안에 String있다-> Orange의 두번째 생성자 호출
		//this("말랑이");
		System.out.println("Orange의 3번째 생성자: "+ n);
		
	}

}


////////////////////////
public class L02_ConstTest {

	public static void main(String[] args) {
		
		Apple apple = new Apple();
		Banana banana = new Banana("바나나");
		Orange or1 = new Orange();
		Orange or2 = new Orange("오렌지");
		Orange or3 = new Orange(22);
		
	}

}
