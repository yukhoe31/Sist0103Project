package day0112;

//부모클래스
public class L05_Sawon {
	
	protected String name;
	protected String buseo;//private으로 하면 안된다!
	
	//메서드
	public void display() {
		System.out.println("**부모클래스 변수 출력**");
		System.out.println("이름: "+this.name);
		System.out.println("부서: "+this.buseo);
		
	}
}
