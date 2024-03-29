package day0115;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Shop1{
	
	private String sangName;
	private int su;
	private int dan;
	
	//getter setter
	public String getSangName() {
		return sangName;
	}
	public void setSangName(String sangName) {
		this.sangName = sangName;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	//총계 계산 메서드
	public int total() {
		int total = this.su * this.dan ;
		return total;
	}
	
	
}

public class P01_ShopArrayList {
	
	List<Shop1> list = new ArrayList<>();
	

	public void ipgo() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입고된 상품명?");
		String name = sc.nextLine();
		System.out.println("가격은?");
		int price = Integer.parseInt(sc.nextLine());
		System.out.println("수량은?");
		int num = Integer.parseInt(sc.nextLine());
		
		Shop1 sh = new Shop1();//sh변수 생성
		sh.setSangName(name);
		sh.setDan(price);
		sh.setSu(num);
		
		list.add(sh);
		
		System.out.println("현재 입고된 상품 개수: " + list.size() +"개 입니다.");

	}

	public void jego() {
		
		System.out.println("**상품 재고 현황**");
		System.out.println("번호\t상품명\t단가\t수량\t총계");
		System.out.println("======================================");
		
		for(int i=0;i<list.size();i++) {
			
			Shop1 sh = new Shop1();
			sh = list.get(i);
			
			System.out.println((i+1)+"\t"+sh.getSangName() 
			+"\t"+sh.getDan()+"\t"+sh.getSu()
			+"\t"+sh.total());
			
			System.out.println("-------------------------------------");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P01_ShopArrayList sh = new P01_ShopArrayList();
		
		boolean b = true;
		
		while(b) {
			System.out.println("1.상품입고  2.재고현황  9.종료");
			Scanner sc = new Scanner(System.in);
			int n = Integer.parseInt(sc.nextLine());
			
			switch(n) {
			case 1:
				sh.ipgo();
				break;
			case 2:
				sh.jego();
				break;
			case 9:
				System.out.println("**종료합니다.**");
				b = false;
				break;
			default:
				System.out.println("다시 쳐주세요.");
				break;
			}
		}
		
	}

}
