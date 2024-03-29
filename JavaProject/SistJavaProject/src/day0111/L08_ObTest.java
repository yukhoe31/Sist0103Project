package day0111;

class Score{
	
	private String stuName;
	private int java;
	private int oracle;
	
	public static final String TITLE = "2023년도 기말고사";

	//getter and setter
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	
	
	
	//추가할 메서드
	//합계 메서드
	public int getTot() {
		
		int total = java + oracle;
		return total;
	}
	//평균 메서드
	public double getAvg() {
		
		double avg = getTot()/2.0;
		return avg;
	}
	
}


/////////////////////
public class L08_ObTest {

	public static void main(String[] args) {
		
		Score s1 = new Score();
		s1.setStuName("박지선");
		s1.setJava(90);
		s1.setOracle(88);
		
		int tot1 = s1.getTot();//getTot()메서드의 return값 받기.
		double avg1 = s1.getAvg();//getAvg()메서드의 return값 받기.
		
		System.out.println("**Score클래스**");
		
		System.out.println(Score.TITLE);
		//Score.TITLE = "기말고사"; //final상수라 수정안됨
		System.out.println("이름: " + s1.getStuName());
		System.out.println("자바점수: " + s1.getJava());
		System.out.println("오라클점수: " + s1.getOracle());
		System.out.println("합계: " + tot1);//위에서 이미 받았으므로, s1.total쓸 필요 없다.
		System.out.println("평균: " + avg1);
	}

}
