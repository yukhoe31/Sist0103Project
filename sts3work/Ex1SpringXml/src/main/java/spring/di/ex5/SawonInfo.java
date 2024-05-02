package spring.di.ex5;

public class SawonInfo {
	
	private String sawonname;//持
	private String buseo;
	private int pay;
	private String level;//持
	
	//持失切
	public SawonInfo(String sawonname, String level) {
		// TODO Auto-generated constructor stub
		this.sawonname = sawonname;
		this.level = level;

	}
	


	public String getSawonname() {
		return sawonname;
	}



	public void setSawonname(String sawonname) {
		this.sawonname = sawonname;
	}



	public String getLevel() {
		return level;
	}



	public void setLevel(String level) {
		this.level = level;
	}



	//setter
	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getBuseo() {
		return buseo;
	}

	public int getPay() {
		return pay;
	}	

}
