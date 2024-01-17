package day0117;

public class L07_MyShop {

	private String sangpum;
	private int su;
	private int price;
	private int total;
	
	//디폴트 생성자
	public L07_MyShop() {

	}
	
	//명시적 생성자
	public L07_MyShop(String sangpum, int su, int price) {
		this.sangpum = sangpum;
		this.su = su;
		this.price = price;
	}
	
	//getter setter
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}
