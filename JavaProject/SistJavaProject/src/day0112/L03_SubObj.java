package day0112;

				//부모(Super)로부터 상속받기
public class L03_SubObj extends L03_SuperObj{
	
	String addr;//자식의 자체 변수

	//부모의 생성자 상속받음.(자동생성)
	public L03_SubObj(String name, int age, String addr) {
		super(name, age);//반드시 첫줄, 부모생성자 호출
		this.addr = addr;//자식의 자기자신의 변수
	}
	
	//ps:부모한테 디폴트 생성자가 없으면->자식한테도 없어야한다.
	//   자식에게만 디폴트 생성자가 있으면 오류가 난다.

	public void writeData() {
		System.out.println("이름: "+this.name);//부모로부터
		System.out.println("나이: "+this.age);//부모로부터
		System.out.println("주소: "+this.addr);//자식만의 것
	}
	
}
