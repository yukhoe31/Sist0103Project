package day0112;

//부모 클래스
class Color{
	
	public void hello() {
		System.out.println("안녕하세요~~~~");
	}
}
//////////////////
class Red extends Color{
	
	public void process() {
		System.out.println("나의 차는 빨강색이야.");
	}
}
//////////////////
class Green extends Color{
	
	public void process() {
		System.out.println("나의 차는 초록색이야.");
	}
	
}
///////////////////
class Blue extends Color{
	
	public void process() {
		System.out.println("나의 차는 파란색이야.");
	}
	
}
//////////////////
class Pink extends Color{
	
	public void process() {
		System.out.println("나의 차는 분홍색이야.");
	}
}
//////////////////
public class L09_Inherit {

	public static void main(String[] args) {
			
		//자식클래스로 선언: extends 부모
		System.out.println("1.Red로 선언하고 Red로 생성한 경우");
		Red red = new Red();
		red.hello();
		red.process();
		
		System.out.println("2.Green으로 선언하고 Red로 생성한 경우");
		Green green = new Green();
		green.hello();
		green.process();
		
		System.out.println("3.Blue로 선언하고 Red로 생성한 경우");
		Blue blue;
		blue = new Blue();
		blue.hello();
		blue.process();
		
		System.out.println("4.Pink로 선언하고 Red로 생성한 경우");
		Pink pink = new Pink();
		pink.hello();
		pink.process();
		
		//부모로 선언하고 자식클래스로 생성
		//부모가 가지고 있는 메소드 호출 ok
		//메서드가 오버라이드 된 경우 호출 ok
		//부모한텐 없고 자식만 갖고있는 경우 메소드 호출 안됨!!
		Color color;
		color = new Red();
		
		color.hello();
		//color.process(); 
		//호출 안됨.->이유:부모한텐 없고 자식만 갖고있는 경우 메소드 호출 안됨!!
	}
}
