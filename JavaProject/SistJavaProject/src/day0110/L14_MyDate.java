package day0110;

class MyDate{
	
	private int year;
	private int month;
	private int day;
	
	//디폴트 생성자
	public MyDate() {
	
	}
	
	//명시적 생성자_ 생성과 동시에 초기화
	public MyDate(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}
	
	//setter
	public void setYear(int y) {
		this.year = y;
	}
	public void setMonth(int m) {
		this.month = m;//this.없어도 괜찮다. month이름이 같으니까.
	}
	public void setDay(int d) {
		day = d;
	}
	
	//getter
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	
}



public class L14_MyDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//명시적 생성자 이용하기.
		//setter없어도 파라미터 존재하므로 ok
		MyDate m1 = new MyDate(2024,01,10);
		
		int year = m1.getYear();
		int month = m1.getMonth();
		int day = m1.getDay();
		
		System.out.println(year + "-" + month + "-" + day);
		
		
		//디폴트 생성자 이용하기.		
		MyDate m2 = new MyDate();
		//setter가 있어야...
		m2.setYear(2022);
		m2.setMonth(9);
		m2.setDay(11);
		
		int y = m2.getYear();
		int m = m2.getMonth();
		int d = m2.getDay();
		
		System.out.println(y +"년"+ m +"월"+ d +"일");
		
	}

}
