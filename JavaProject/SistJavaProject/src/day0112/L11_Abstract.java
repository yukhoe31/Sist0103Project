package day0112;

//추상클래스
//추상클래스는 new로 생성못함
//abstract 메서드는 abstract 클래스에서만 존재할 수 있다.
//abstract 클래스는 일반 메서드 추상메서드 둘다 포함이 가능하다.

abstract class Fruit{

	public static final String MESSAGE = "오늘은 추상클래스 배우는날~~";

	//일반메서드
	public void showTitle() {
		System.out.println("일반메서드 입니다.");
	}

	//추상메서드(미완의 메서드, 구현부가 없다)...오버라이딩이 목적
	abstract public void showMessage();

}
//////////////////////
class Apple extends Fruit{

	@Override
	public void showMessage() {
		System.out.println(Fruit.MESSAGE);
		System.out.println("Apple_Message");
	}

}
///////////////////////
class Orange extends Fruit{

	@Override
	public void showMessage() {
		System.out.println("Orange_Message");

	}
}
///////////////////////
class Banana extends Fruit{

	@Override
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

		//다형성출력(부모로 선언, 자식으로 생성)_장점은 변수가 하나

		//부모클래스명 변수명 = new 자식클래스명
		Fruit fruit;
		fruit = new Apple();
		fruit.showMessage();
		fruit.showTitle();

		fruit = new Banana();
		fruit.showMessage();
		fruit.showTitle();

		fruit = new Orange();
		fruit.showMessage();
		fruit.showTitle();
			
		//추상클래스 생성 -> 생성불가(오류난다)
		//Fruit fr = new Fruit();
	}

}
