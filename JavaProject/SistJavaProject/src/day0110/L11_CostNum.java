package day0110;

//생성자(Constructor): 객체 생성시 자동호출되는 메서드
//1.일반메서드와 차이점: 리턴형이 없다.
//2.반드시 클래스명과 동일해야한다.
//3.Overloading이 가능하다.(여러개의 생성자 만들 수 있다.)
//4.생성자가 없을 경우 기본생성자로 생성가능.
//5.멤버값들이 주로 초기화를 담당.



//public class 두개 안됨.
class Numb{
	
	int num; //0
	
	//디폴트 생성자
	public Numb() {
		this.num = num;
		System.out.println("인자없는 디폴트 생성자 호출");
	}
	
	//인자'있는' 생성자
	public Numb(int num) {
		this.num = num;//this뜻: 나 자신
		System.out.println("인자있는 생성자 호출");
	}
	
	//메서드
	public int getNumber() {
		num = 50;
		return num;	
	}
	
	
}

//public class명으로 무조건 하나 존재해야.
public class L11_CostNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//디폴트 생성자 호출
		Numb n1 = new Numb();
		
		//인자있는 인스턴스 생성자 호출
		Numb n2 = new Numb(30);
		System.out.println(n2.num);
		
		//인스턴스 메서드 호출
		Numb n3 = new Numb();
		System.out.println(n3.getNumber());
		
		
	}

}
