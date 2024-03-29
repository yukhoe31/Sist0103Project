package day0112;

/*
 **디폴트 생성자로 생성**
회사명: 현대
종류: 전기차 트럭
자동차명: 아이오닉5
색상: 블랙
가격: 35000000원

 **명시적 생성자로 생성**
회사명: 기아
종류: 가솔린
자동차명: 코나
색상: 화이트
가격: 25000000원

 **부모 메서드 출력**
회사명: 현대
종류: 전기차 트럭
 */


//부모클래스
class Car{

	private String carCompany; //제조회사
	private String car;//종류

	//setter getter --> 안쓰더라도 만들어준다.
	public String getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}


	//디폴트 생성자
	public Car() {
		this("현대", "전기차 트럭");
	}


	//명시적 생성자
	public Car(String company, String jong) {
		// TODO Auto-generated constructor stub
		this.carCompany = company;
		this.car = jong;	

	}

	//show 메서드
	public void showData() {

		System.out.println("회사명: "+carCompany);
		System.out.println("종류: "+car);
	}
	
}


//////////////////////////


//자식클래스
class MyCar extends Car{

	private String carName;
	private String carColor;
	private int carPrice;


	//setter getter --> 안쓰더라도 만들어준다.
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}


	//디폴트 생성자:super가 안써있더라도 이미 생략된 걸로 이해해라.
	public MyCar() {
		//carName = "아이오닉5";
		//carColor = "블랙";
		//carPrice = 35000000;
	}


	//명시적 생성자
	public MyCar(String company, String jong, String name,String color, int price) {
		super(company,jong);
		this.carName = jong;
		this.carColor = color;
		this.carPrice = price;
	}

	//오버라이드 메서드(매서드 재정의)
	@Override
	public void showData() {

		super.showData();

		System.out.println("자동차명: " +carName);
		System.out.println("색상: " +carColor);
		System.out.println("가격: " +carPrice);
	}

}


//////////////////////////
public class L08_Inherit{
	public static void main(String[] args) {

		MyCar my1 = new MyCar();
		my1.setCarName("아이오닉5");
		my1.setCarColor("블랙");
		my1.setCarPrice(35000000);


		MyCar my2 = new MyCar("기아","가솔린","코나","화이트",25000000);

		System.out.println("**디폴트 생성자로 생성**");
		my1.showData();

		System.out.println();

		System.out.println("**명시적 생성자로 생성**");
		my2.showData();

		System.out.println();

		System.out.println("**부모 메서드 출력**");
		Car c1 = new Car();
		c1.showData();

	}
}
