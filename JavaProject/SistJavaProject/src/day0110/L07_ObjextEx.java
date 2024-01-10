package day0110;

public class L07_ObjextEx {
	
	String name; //인스턴스 멤버변수..반드시 생성을 한 수 쓸 수 있다.
	
	//변수가 절대절대 못바꾸는 final
	static final String MESSAGE = "Happy day";
	//static 멤버변수.. 주로 상수로 선언
	//객체생성없이 바로 클래스명으로 접근가능

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("static 멤버변수는 new생성없이 호출가능하다.");
		System.out.println(MESSAGE); //다른클래스에서는 클래스명.변수명으로 가져와야한다.
		//MESSAGE = "Nice day!!"; //=>final때문에 오류난다.
		
		
		
		//System.out.println(name);
		//인스턴스 변수 객체 생성
		L07_ObjextEx ob7 = new L07_ObjextEx();
		
		System.out.println(ob7.name);
		ob7.name = "홍길동";
		
		System.out.println(ob7.name);
		
		
		
		//인스턴스 변수 객체 생성
		L07_ObjextEx ob8 = new L07_ObjextEx();
		ob8.name = "이효리";
		System.out.println(ob8.name);
		
	}
}
