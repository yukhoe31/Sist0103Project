package day0112;

/*
[쌍용매장 입고상품]

번호	상품명	   가격	        색상	
========================================
1		요가매트   25000원      핑크
2		아령	   30000원      블랙
3		레깅스	   45000원      베이지
4		나시	   22000원      화이트
*/

class Ipgo{
	
	//
	private String name;
	private int price;
	private String color;
	
	private static int count = 0;
	
	//명시적 생성자
	public Ipgo(String name, int price, String color) {
		
		this.name = name;
		this.price = price;
		this.color = color;
		
	}
	
	//showTitle메서드
	public static void showTitle() {
		System.out.println("[쌍용매장 입고상품]");
		System.out.println("번호\t상품명\t\t가격\t색상");
		System.out.println("========================================");
	}
	//show 메서드
	public void showIpgo() {
		count++;
		
		
		System.out.println(count + "\t" + name + "    \t" + price +"원\t" + color);
		
	}
	
}

public class L02_ArrReview {

	public static void main(String[] args) {
		
		Ipgo [] ip = new Ipgo[4];
		
		
		ip[0] = new Ipgo("요가매트",25000,"핑크");
		ip[1] = new Ipgo("아령",30000,"블랙");
		ip[2] = new Ipgo("레깅스",45000,"베이지");
		ip[3] = new Ipgo("나시",22000,"화이트");
		
		Ipgo.showTitle();
		
		for(Ipgo i:ip) {
			i.showIpgo();
		}

	}

}
