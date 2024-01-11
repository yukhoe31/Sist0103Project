package day0111;

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
	public static void show() {

		System.out.println("***쌍용 01월 직원 급여현황***");
		System.out.println();
		System.out.println("사원명\t기본급\t추가수당\t실수령액");
		System.out.println("========================================");

	}

}

public class L16_QuizSawon {

	public static void main(String[] args) {
		
		Sawon.show();

	}

}
