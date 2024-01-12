package day0112;

import day0112.L05_Sawon;

//My:자식클래스,L05_Sawon:부모클래스
class My extends L05_Sawon{
	
	int age;
	
	public My(String name, String buseo, int age) {
		//부모클래스가 패키지가 다를경우, 
		//protected 접근제한자는 접근이 가능하다.
		this.name = name;
		this.buseo = buseo;
		this.age = age;//이건 My거
	}
	
	public void writeMy() {
		System.out.println("**My에서 만든 메서드**");
		System.out.println("사원명: "+this.name);
		System.out.println("부서: "+this.buseo);
		System.out.println("나이: "+this.age);
	}
	
	//오버라이드 구현
	@Override
	public void display() {
		// TODO Auto-generated method stub
		super.display();//L05_Sawon 클래스에서 받아옴.
		System.out.println("나이==>" + this.age);
		System.out.println("**자식이 오버라이드 한 메서드**");
	}
}

public class L05_MainSawon {

	public static void main(String[] args) {
		
		My my1 = new My("이영자","인사부",22);	
		my1.writeMy();
		System.out.println();
		
		System.out.println("오버라이드를 통해 만든 호출");
		my1.display();
	}

}
