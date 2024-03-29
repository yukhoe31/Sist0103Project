package day0110;

//실행결과
/*
 * 포르쉐가 달립니다. (시속:100km/h)
 * 벤츠가 달립니다. (시속:100km/h) 
 */

//방법1: 책에서 한 방법
class Car {
	//필드 선언
	String name;
	int speed;
	
	//생성자 선언
	Car(String name){
		this.name = name;
	}
	

	//메소드 선언
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void run() {
		this.setSpeed(100);
		System.out.println(this.name +"가 달립니다. (시속:"+this.speed +"km/h)");
	}

}


public class L17_Book243 {

	public static void main(String[] args) {
		
		Car c1 = new Car("포르쉐");
		Car c2 = new Car("벤츠");
		
		c1.run();
		c2.run();
		

	}

}


//방법2: 내가 한 방법
/*
class Car{
	String name;
	int speed;
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	//getter
	public String getName() {
		return name;
	}
	public int getSpeed() {
		return speed;
	}
	
}

///////////////////////////
public class L17_Book243 {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		c1.setName("포르쉐");
		c1.setSpeed(100);
		String name1 = c1.getName();
		int speed1 = c1.getSpeed();
		
		Car c2 = new Car();
		c2.setName("벤츠");
		c2.setSpeed(100);
		String name2 = c2.getName();
		int speed2 = c2.getSpeed();
		
		System.out.println(name1 + "가 달립니다. (시속: "+ speed1+"km/h)");
		System.out.println(name2 + "가 달립니다. (시속: "+ speed2+"km/h)");
		

	}

}
*/