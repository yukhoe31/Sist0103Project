package day0110;


class Mart{
	
	//인스턴스 변수
	private String sangpum;//private으로 시작.
	int su;
	int dan;
	//static 변수
	static String SHOPNAME = "롯데마트";
	
	//sangpum은 메서드가 아니면 다른 클래스에서 접근 불가.
	public void setSangpum(String name) {
		this.sangpum = name;
	}
	
	public String getSangpum() {
	    return sangpum;
	}
	
	//su,dan은 private이 아니므로 다른클래스에서 생성시 변수접근 가능하다.
	//static은 다른클래스에서 접근시 클래스명, 변수명을 접근가능하다.
	
	
	/*
	//디폴트 생성자
	public Mart() {
		
	}
	
	//명시적 생성자
	public Mart(String name, int num, int price) {
		this.sangpum = name;
		this.su = num;
		this.dan = price;
	}
	
	//setter 메서드
	public void setName(String name) {
		this.sangpum = name;
	}
	public void setNum(int num) {
		this.su = num;
	}
	public void setPrice(int price) {
		this.dan = price;
	}
	
	//getter 메서드
	public String getName() {
		return sangpum;
	}
	public int getNum() {
		return su;
	}
	public int getPrice() {
		return dan;
	}
	*/
	
}

public class L16_QuizClass {
		
	//생성후 초기값 준 후 출력하시오.
	
	//**롯데마트 입고물풒**
	//======================
	//상품명: 초코파이
	//수량: 10개
	//가격: 4500원
	//----------------------
	//상품명: 엄마손파이
	//수량: 5개
	//가격: 2500원
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//디폴트 생성자
		Mart m1 = new Mart();
		//setter
		m1.setSangpum("초코파이");
		m1.su = 10;
		m1.dan = 4500;
		//getter
		
		
		//명시적 생성자
		Mart m2 = new Mart();
		//setter
		m2.setSangpum("엄마손파이");
		m2.su = 5;
		m2.dan = 5000;
		
		
		System.out.println("**"+ Mart.SHOPNAME+ " 입고물품**");
		System.out.println("======================");
		
		System.out.println("상품명: " + m1.getSangpum());
		System.out.println("수량: " + m1.su + "개");
		System.out.println("가격: " + m1.dan + "원");
		
		System.out.println("----------------------");
		System.out.println("상품명: " + m2.getSangpum());
		System.out.println("수량: " + m2.su + "개");
		System.out.println("가격: " + m2.dan + "원");
		
		
	}

}
