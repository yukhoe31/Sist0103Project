package day0111;

//class도 일종의 자료형
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
		//배열로 4개 생성해서 출력할 것
		Shop [] shop = new Shop[4]; //null로 초기화 주소값 할당
		//shop[0].showShop();// <-- null포인트 Exception이 발생한다.
		
		//4개의 shop배열에 생성자를 통해서 생성
		shop[0] = new Shop("양말",1000,"빨강");
		shop[1] = new Shop("티셔츠",10000,"노랑");
		shop[2] = new Shop("청바지",25000,"파랑");
		shop[3] = new Shop("모자",5000,"초록");
		
		//출력
		Shop.showTitle();
		
		for(Shop s:shop) {
			s.showShop();
		}
		
		//아래 방법도 가능하다.
		/*
		for(int i=0;i<shop.length; i++) {
			shop[i].showShop();
		}
		*/
	}

}
