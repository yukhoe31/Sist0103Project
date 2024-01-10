package day0110;

import java.util.Calendar;

class Test{
	
	public Test() {
		System.out.println("디폴트 생성자");
	}
	
	//생성자 대신 인스턴스를 반환해주는 메서드
	public static Test getInstance() {
		return new Test();
	}
	
	public void writeMessage() {
		System.out.println("안녕~~~~");
	}
}

/////////////////
public class L15_GetInstance {

	public static void main(String[] args) {
		
		//Test t1 = new Test();
		Test t1 = Test.getInstance();
		t1.writeMessage();
		
		Calendar cal = Calendar.getInstance();
		//return 타입: Calendar
		int year = cal.get(cal.YEAR);
		
		System.out.println(year+"년도");
				
		

	}

}
