package day0112;

class School{
	
	public static final String SCHOOLNAME ="쌍용고등학교";
	private String schoolAddr;
	private int countStu;
	private int countTeacher;
	
	//setter getter	
	public String getSchoolAddr() {
		return schoolAddr;
	}

	public void setSchoolAddr(String schoolAddr) {
		this.schoolAddr = schoolAddr;
	}

	public int getCountStu() {
		return countStu;
	}

	public void setCountStu(int countStu) {
		this.countStu = countStu;
	}

	public int getCountTeacher() {
		return countTeacher;
	}

	public void setCountTeacher(int countTeacher) {
		this.countTeacher = countTeacher;
	}

	
	//생성자
	public School() {
		this("강남구 역삼동", 120, 10);
		
	}
	
	public School(String saddr, int cntstu, int cntteacher) {
		this.schoolAddr = saddr;
		this.countStu = cntstu;
		this.countTeacher = cntteacher;
	}
	
	//메서드
	public void writeData() {
		System.out.println("학교주소: "+ this.schoolAddr);
		System.out.println("학교수: "+ this.countStu +", 선생님수:" + this.countTeacher);
	}
	
}

///////////////////
class Student extends School{
	
	private String stuName;
	private int grade;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
		//여기 아무것도 안적으면 학생수:null, 학년:0학년 나옴.
		//그게 싫으면 아래처럼 쓸것.(대충 기본세팅 학생 프로필임)
	    stuName = "홍길동";
	    grade = 1;
	}
	
	public Student(String sAddr, int cntStu, int cntTea, String stuname, int gra) {
		super(sAddr,cntStu,cntTea);
		this.stuName = stuname;
		this.grade = gra;
	}

	//각각의 setter getter
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	//재정의 메서드
	@Override
	public void writeData() {//<-부모클래스인 School에 이미 있는 메서드를 가져온다. 그리고 여기에 추가로 뭔갈 한다.
		// TODO Auto-generated method stub
		super.writeData();
		
		System.out.println("학생명: " + stuName);
		System.out.println("학년: " + grade + " 학년");
	}
	
}

//////////////////
public class L07_Inherit {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		System.out.println("[1번째 학생]");
		s1.writeData();
		System.out.println();
		
		
		Student s2 = new Student("영등포구", 300, 25, "김숙", 2);
		System.out.println("[2번째 학생]");
		s2.writeData();
		System.out.println();
		
		
		System.out.println("※1번째 학생 학생명과 학년 변경후 출력");
		s1.setStuName("이영자");
		s1.setGrade(3);
		System.out.println("[1번째 학생]");
		s1.writeData();
		
	}
}
