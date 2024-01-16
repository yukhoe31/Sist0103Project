package day0116;

import java.util.Scanner;

class SawonOuter{

	private String sawonName;
	private int gibonPay,familySu,timeSu;

	
	public void process() {

		//데이터 입력
		InputInner input = new InputInner();
		input.writeSawonData();

		//결과출력
		SudangInner output = new SudangInner();
		output.showSawonData();

	}
	
	//일반 메서드
	public int getTimeSudang() {
		return timeSu*30000;
	}

	public int getFamilySudang() {
		if(familySu <= 4) {
			return 200000;
		}else {
			return 300000;
		}
	}

	public int getTax() {
		return (int)(gibonPay*0.03);
	}

	public int getTotalPay() {
		return gibonPay + getTimeSudang() - getTax();
	}

	
	
	//내부클래스 InputInner
	class InputInner{


		public void writeSawonData() {
			//데이터 입력
			Scanner sc = new Scanner(System.in);

			System.out.println("사원명 입력: ");
			sawonName = sc.nextLine(); //sawonName에 바로 입력 가능

			System.out.println("기본급은?");
			gibonPay = sc.nextInt();

			System.out.println("초과시간은?");
			timeSu = sc.nextInt();

			System.out.println("가족수는?");
			familySu = sc.nextInt();

		}


	}

	class SudangInner{
		public void showSawonData() {

			System.out.println("사원명\t기본급\t초과시간\t가족수\t시간수당\t가족수당\t세금\t총급여");
			System.out.println("============================================="
					+ "==========================================");
			System.out.println(sawonName + "\t" +gibonPay
					+"\t"+timeSu+"\t\t"+familySu+"\t"
					+getTimeSudang()+"\t\t"+getFamilySudang()
					+"\t\t"+getTax()+"\t"+getTotalPay());

		}
	}

}

///////////////////////////
public class L10_QuizInnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//방법1: 내부클래스를 외부클래스 통해서 생성후 메서드 호출
		SawonOuter sawon = new SawonOuter();

		SawonOuter.InputInner input = sawon.new InputInner();
		input.writeSawonData();//데이터 입력

		SawonOuter.SudangInner output = sawon.new SudangInner();
		output.showSawonData();//데이터 출력

		System.out.println("--------------------------");
		
		//방법2: 외부클래스의 멤버에서 내부클래스의 멤버를 호출 후,
		//메인에서는 외부클래스생성 외부메서드 호출
		SawonOuter sa = new SawonOuter();
		sa.process();

	}

}
