package spring.data;

public class PhotoDto {
	
	private String foodname;
	private String photo;

	//»ý¼ºÀÚ
	public PhotoDto(String fname, String photo) {
		// TODO Auto-generated constructor stub
		this.foodname = fname;
		this.photo = photo;
		
	}
	
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
