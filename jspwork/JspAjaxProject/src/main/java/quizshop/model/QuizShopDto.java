package quizshop.model;

import java.sql.Timestamp;

public class QuizShopDto {
	
	private String num;
	private String sang_num;
	private String photo;
	private int price;
	private String ipgoday;
	private Timestamp writeday;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getSang_num() {
		return sang_num;
	}
	public void setSang_num(String sang_num) {
		this.sang_num = sang_num;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIpgoday() {
		return ipgoday;
	}
	public void setIpgoday(String ipgoday) {
		this.ipgoday = ipgoday;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
	
	
	
	
}
