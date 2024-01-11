package day0111;

class Shop{
	
	private String sangpum;
	private int price;
	private String sangColor;
	
	public Shop(String s, int p, String c) {
		sangpum = s;
		price = p;
		sangColor = c;
	}
	
	//제목
	public static void showTitle() {
		System.out.println("상품명\t가격\t색상");
		System.out.println("======================");
	}
	
	//생성한 갯수만큼 출력
	public void showShop() {
		System.out.println(sangpum+"\t"+price + "원\t" + sangColor);
	}
}

public class L11_ArrObTest {

	public static void main(String[] args) {
		//4개 생성해서 출력할 것
		
		Shop s1 = new Shop("양말",1000,"빨강");
		Shop s2 = new Shop("티셔츠",10000,"노랑");
		Shop s3 = new Shop("청바지",25000,"파랑");
		Shop s4 = new Shop("모자",5000,"초록");
		
		Shop.showTitle();
		s1.showShop();
		s2.showShop();
		s3.showShop();
		s4.showShop();
		
	}

}
