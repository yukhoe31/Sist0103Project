package day0111;

import java.util.Scanner;

//"디폴트 생성자"를 사용해서 할것.

/*
회사이름
쌍용

총사원수 입력
2
사원명
손흥민
월급여
2500000
월수당
500000

[쌍용_1월 급여내역]
사원명	기본급	추가수당 실수령액(-세금:10%)
================================
손흥민	2500000 500000	 2700000
황희찬	1500000	500000	 1800000

 */

class Sawon{
	private String name;
	private int basicPay;
	private int sudang;

	static String company;

	//getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(int basicPay) {
		this.basicPay = basicPay;
	}

	public int getSudang() {
		return sudang;
	}

	public void setSudang(int sudang) {
		this.sudang = sudang;
	}

	//메서드
	//실수령액계산 메서드
	public int payCal() {

		int result = (int) ((this.basicPay + this.sudang)*0.9);
		return result;
	}

	//화면출력 메서드
	//제목출력
	public static void showTitle() {

		System.out.println("[쌍용 01월 직원 급여현황]");
		System.out.println();
		System.out.println("사원명\t기본급\t추가수당\t실수령액");
		System.out.println("========================================");

	}

}

public class L16_QuizSawon {
	
	public static void writeAll(Sawon[] sa) {
		Sawon.showTitle();
		
		for(Sawon s:sa) {
			System.out.println(s.getName()+"\t"
			+ s.getBasicPay()+"\t"+s.getSudang() 
			+ "\t"  + s.payCal());
			
		}
		
	}
	

	public static void main(String[] args) {
		
		int inwon;
		Scanner sc = new Scanner(System.in);
		System.out.println("총사원수 입력:");
		inwon = Integer.parseInt(sc.nextLine());
		
		
		Sawon [] sa = new Sawon[inwon];
		
		
		for(int i=0;i<inwon;i++) {
			
			sa[i] = new Sawon();
			System.out.print("사원명 입력:");
			String name = sc.nextLine();
			System.out.print("기본급 입력:");
			int basic = Integer.parseInt(sc.nextLine());
			System.out.print("추가수당 입력:");
			int plus = Integer.parseInt(sc.nextLine());

			sa[i].setName(name);
			sa[i].setBasicPay(basic);
			sa[i].setSudang(plus);
			//sa[i].payCal();
			
			sa[i].getName();
			sa[i].getBasicPay();
			sa[i].getSudang();
			
		}
				
		writeAll(sa);	

	}

}
