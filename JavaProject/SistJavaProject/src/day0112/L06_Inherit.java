package day0112;

class Emart{
	
	private String sangpum;
	private int su;
	
	public Emart() {
		//sangpum = "딸기";
		//su = 10;
		this("딸기", 10);//<-위에 주석 단거 말고 이렇게 써도 된다.
	}
	
	public Emart(String sangpum, int su) {
		this.sangpum = sangpum;
		this.su = su;
		
	}
	
	public void writeMart() {
		System.out.println("상품명: "+ sangpum);
		System.out.println("수량: "+ su);
	}
	
}

/////////////////
class KangnamEmart extends Emart{
	
	private int price;
	
	KangnamEmart() {
		price = 10000;
	}
	
	KangnamEmart(String sangpum, int su, int price) {
		super(sangpum, su);
		this.price = price;
	}
	
	//재정의
	@Override
	public void writeMart() {
		// TODO Auto-generated method stub
		super.writeMart();//재정의한 메서드는 무조건 맨 위에 있지 않아도 된다.
	}
	
}

public class L06_Inherit {
	
	public static void main(String[] args) {
		
		KangnamEmart kang1 = new KangnamEmart();
		kang1.writeMart();
		
		System.out.println();
		
		KangnamEmart kang2 = new KangnamEmart();
		kang2.writeMart();
				
	}
}
