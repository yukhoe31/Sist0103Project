package day0112;

import java.util.Scanner;

/*
[과제물_0112]

1.콘솔창의 결과물 한 장만 카톡으로 보낼것!!
2.클래스명은 QuizMain으로 만들어주세요.
3.멤버클래스명은 Quiz라고 만드세요.
4.메인메서드에서 학교이름 입력받아 schoolName에 넣고
  인원수 입력받아서 인원수만큼
  이름,Java,Oracle,Html 점수를 입력한후
  총점,      평균,      평가 메서드를 만들어 구현하세요.
  getTotal(),getAverge(),getPyungga() => 대충 이런식으로 메서드명 정하라는 뜻.
  
  평가는 90점이상: 장학생   80점이상: 합격  80점미만:불합격임 

  다음과 같이 구현할것

  학교명: 쌍용교육센터

이름	 JAVA	ORACLE	HTML  	총점	평균	평가
========================================================
홍현희	 90	    80	    70	    240	     80	     합격
남현희	 80		60	  	50      190      63.5    불합격
*/

class Quiz{
	private String name;
	private int java;
	private int oracle;
	private int html;

	
	private static String shcoolName;

	//getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public static String getShcoolName() {
		return shcoolName;
	}

	public static void setShcoolName(String shcoolName) {
		Quiz.shcoolName = shcoolName;
	}
	
	
	//메서드 만들기
	public int getTotal() {
		// TODO Auto-generated method stub
		int total = this.html + this.java +this.oracle;
		return total;
	}
	
	public double getAverage() {
		int total = getTotal();
		double avg = Math.round((total/3.0)*10)/10;
		//*10하고 /10하는 이유: 소수점 1자리수까지 얻기 위함.
		return avg;
	}
	
	public String getPyungga() {
		double avg = getAverage();
		String result = "불합격";
		
		if(avg>=90) {
			result =  "장학생";
		}else if(avg>=80){
			result = "합격";
		}else {
			result = "불합격";
		}
		return result;
	}
	
	//제목출력 메서드
	public void showTitle() {
		System.out.println("학교명:" + this.shcoolName);
		System.out.println("이름\tJAVA\tORACLE\tHTML\t총점\t평균\t평가");
		System.out.println("=================================================");	
	}
		
}


public class L15_QuizMain {

	public static void main(String[] args) {
		
		Quiz q = new Quiz();
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println("학교이름 입력: ");
		String scName = sc.nextLine();
		q.setShcoolName(scName);
		
		System.out.println("인원수 입력: ");
		int inwon = Integer.parseInt(sc.nextLine());
		
		String name;
		int java;
		int oracle;
		int html;
		
		Quiz [] q1 = new Quiz[inwon];
		
		for(int i=0;i<inwon;i++) {
			
			q1[i] = new Quiz();
			
			System.out.println("학생이름 입력: ");
			name = sc.nextLine();		
			q1[i].setName(name);
			
			System.out.println("JAVA점수 입력: ");
			java = Integer.parseInt(sc.nextLine());		
			q1[i].setJava(java);
			
			System.out.println("ORACLE점수 입력: ");
			oracle = Integer.parseInt(sc.nextLine());		
			q1[i].setOracle(oracle);
			
			System.out.println("HTML점수 입력: ");
			html = Integer.parseInt(sc.nextLine());		
			q1[i].setHtml(html);
			
			System.out.println();
		}
		
		//화면출력
		
		//제목출력
		q.showTitle();
		//나머지 내용 출력
		for(int i=0;i<inwon;i++) {
			System.out.println(q1[i].getName()+"\t"+q1[i].getJava()
					+"\t"+q1[i].getOracle()+"\t"+q1[i].getHtml()
					+"\t"+q1[i].getTotal()+"\t"+q1[i].getAverage()
					+"\t"+q1[i].getPyungga());
		}

	}

}
