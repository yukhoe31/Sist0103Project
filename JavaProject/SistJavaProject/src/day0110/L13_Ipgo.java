package day0110;

class Ipgo{
	private String sangName;
	private int Price;
	
	//set메서드
	public void setName(String name) {
		this.sangName = name;
	}
	public void setPrice(int price) {
		this.Price = price;
	}
	
	//get메서드
	public String getName() {
		return sangName;
	}
	public int getPrice() {
		return Price;
	}
	
	
}

public class L13_Ipgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//생성1
		Ipgo ip1 = new Ipgo();
		
		ip1.setName("수박");
		ip1.setPrice(20000);
		
		String name = ip1.getName();
		int price = ip1.getPrice();
		
		
		//생성2
		Ipgo ip2 = new Ipgo();
		
		ip2.setName("오렌지");
		ip2.setPrice(2000);
		
		String name2 = ip2.getName();
		int price2 = ip2.getPrice();
		
		System.out.println(name +", "+ price + "원");
		System.out.println(name2 +", "+ price2 + "원");

	}

}
