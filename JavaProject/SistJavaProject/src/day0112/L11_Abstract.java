package day0112;

//추상클래스
//추상클래스는 new로 생성못함
//"abstract 메서드"는 "abstract 클래스"에서만 존재할 수 있다.
//abstract 클래스는 일반 메서드 추상메서드 둘다 포함이 가능하다.

abstract class Fruit{

	public static final String MESSAGE = "오늘은 추상클래스 배우는날~~";

	//일반메서드
	public void showTitle() {
		System.out.println("일반메서드 입니다.");
	}

	//추상메서드(미완의 메서드, "선언부만 존재" 구현부가 없다)...오버라이딩이 목적
	//자바에서 추상 메소드를 선언하여 사용하는 목적은 
	//추상 메소드가 포함된 클래스를 상속받는 자식 클래스가 반드시 추상 메소드를 구현하도록 하기 위함입니다.
	//즉, 반드시 사용되어야 하는 메소드를 추상 클래스에 추상 메소드로 선언해 놓으면, 
	//이 클래스를 *상속받는 모든 클래스*에서는 이 *추상 메소드를 반드시 재정의*해야 합니다.
	abstract public void showMessage();

}
//////////////////////
class Apple extends Fruit{

	@Override//재정의
	public void showMessage() {
		System.out.println(Fruit.MESSAGE);
		System.out.println("Apple_Message");
	}

}
///////////////////////
class Orange extends Fruit{

	@Override//재정의
	public void showMessage() {
		System.out.println("Orange_Message");

	}
}
///////////////////////
class Banana extends Fruit{

	@Override//재정의
	public void showMessage() {
		System.out.println("Banana_Message");

	}
}


///////////////////////
public class L11_Abstract {

	public static void main(String[] args) {
		

		//일반생성출력(자식으로 선언, 자식으로 생성)
		Apple apple = new Apple();
		apple.showMessage();

		Banana banana = new Banana();
		banana.showMessage();

		Orange orange = new Orange();
		orange.showMessage();

		System.out.println();
		
		//다형성출력(부모로 선언, 자식으로 생성)_장점은 변수가 "하나"
		//부모클래스명 변수명 = new 자식클래스명
		Fruit fruit;//부모로 선언
		
		//자식으로 생성
		fruit = new Apple();
		fruit.showMessage();//오늘은 추상클래스 배우는날~~\nApple_Message
		fruit.showTitle();//일반메서드입니다.

		//자식으로 생성
		fruit = new Banana();
		fruit.showMessage();//Banana_Message
		fruit.showTitle();//일반메서드입니다.

		//자식으로 생성
		fruit = new Orange();
		fruit.showMessage();//Orange_Message
		fruit.showTitle();//일반메서드입니다.
			
		//추상클래스 생성 -> 생성불가(오류난다)
		//Fruit fr = new Fruit();
	}

}
