package day0112;
//자식클래스
			//자식 				//부모
public class L04_Manager extends L04_Employee{
	
	String depart;//자식만 가진
	
	public L04_Manager(String name, int sal, String d) {
		super(name, sal);//부모생성자 호출
		depart=d;//초기화
	}
 
	//재정의된 메서드_하위클래스에서 부모클래스의 메서드를 "수정"해서 사용하는것
	//Overrriding은 
	//1.상속이 전제조건
	//2.메서드명이 동일해야
	//3.메서드 리턴타입도 동일	
	//즉,getEmployee()메서드는 부모 class인 Employee에서도 존재하는 메서드다.
	//그런데, 자식클래스에서 depart에 관한 내용까지 추가한것.
	@Override 
	public String getEmployee() {
		return super.getEmployee()+" | "+depart;
	}
	
}
