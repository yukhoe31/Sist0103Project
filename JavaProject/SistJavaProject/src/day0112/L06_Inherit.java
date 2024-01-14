package day0112;

//부모클래스
class Emart{
	
	private String sangpum;
	private int su;
	
	//디폴트 생성자
	public Emart() {
		//sangpum = "딸기";
		//su = 10;
		this("딸기", 10);//<-위에 주석 단거 말고 이렇게 써도 된다.
	}
	
	//명시적 생성자
	public Emart(String sangpum, int su) {
		this.sangpum = sangpum;
		this.su = su;
		
	}
	
	//show메소드
	public void writeMart() {
		System.out.println("상품명: "+ sangpum);
		System.out.println("수량: "+ su);
	}
	
}

/////////////////자식클래스
class KangnamEmart extends Emart{
	
	private int price;
	
	KangnamEmart() {
		price = 10000;
	}
	
	KangnamEmart(String sangpum, int su, int price) {
		super(sangpum, su);
		this.price = price;
	}
	
	//재정의(부모클래스에도 같은 이름, 같은 return자료형을 가진 메소드 존재)
	@Override
	public void writeMart() {
		// TODO Auto-generated method stub
		super.writeMart();//재정의한 메서드는 무조건 맨 위에 있지 않아도 된다.
	}
	
}

//메인클래스
public class L06_Inherit {
	
	public static void main(String[] args) {
		
		KangnamEmart kang1 = new KangnamEmart();//객체 생성
		kang1.writeMart();
		
		System.out.println();
		
		KangnamEmart kang2 = new KangnamEmart();//객체 생성
		kang2.writeMart();
				
	}
}
