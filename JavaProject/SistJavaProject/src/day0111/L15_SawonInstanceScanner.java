package day0111;

import java.util.Scanner;
//현재 작동하는걸로는 "명시적 생성자"이용한다.
//"디폴트생성자" 부분은 주석처리됨.

/*
class Emp
모든 멤버는 private
사원명: sName
기본급: gPay
자녀수: fSu
초과근무시간: tSu

setter & getter

//메서드
getFamilySudang() : 가족수당 = 가족수*50000(단 2인이상은 무조건 10만원)
getTimeSudang() : 시간수당 = 초과시간*30000(단 10시간 이상은 30만원으로 통일)
getTotalPay(): 실수령액 = 기본급+가족수당+시간수당

////////////////////////////////

main()에서는 인원수 입력후 해당 사원에 대한 이름,기본급,자녀수,초과근무시간 입력받아서 출력


[직원 1월 급여]  
-->가족수당, 시간수당 계산:메서드 이용
-->사원명, 기본급, 자녀수, 초과근무시간은 Scanner로 입력받기

사원명	기본급	자녀수	초과근무시간    가족수당   시간수당	총급여
------------------------------------------------------------------
*/

class Emp{
	
	private String sName;
	private int gPay;//기본급
	private int fSu;//자녀수
	private int tSu;//초과근무시간
	
	//명시적 생성자
	public Emp(String name, int pay, int fs, int ts) {
		
		this.sName = name;
		this.gPay = pay;
		this.fSu = fs;
		this.tSu = ts;
		
	}
	
	//getter setter
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getgPay() {
		return gPay;
	}
	public void setgPay(int gPay) {
		this.gPay = gPay;
	}
	public int getfSu() {
		return fSu;
	}
	public void setfSu(int fSu) {
		this.fSu = fSu;
	}
	public int gettSu() {
		return tSu;
	}
	public void settSu(int tSu) {
		this.tSu = tSu;
	}
	
	//메서드
	//가족수당 계산 메서드 (리턴값o, 파라미터x)
	public int getFamilySudang() {
		
		int n =0;
		
		if(fSu >= 2) {
			n = 100000;
		}else {
			n = fSu*50000;
		}
		return n;
	}
	
	//초과근무수당 계산 메서드(리턴값o, 파라미터x)
	public int getTimeSudang() {
		
		int n =0;
		
		if(tSu >= 10) {
			n = 300000;
		}else {
			n = tSu*30000;
		}
		
		return n;
	}
	
	//총급여 메서드(리턴값o, 파라미터x)
	public int getTotalPay() {
		int n = gPay + getFamilySudang() + getTimeSudang();
		return n;	
	}
	
	//제목 메서드(리턴값x, 파라미터x)
	public static void showTitle() {
		System.out.println("***쌍용 01월 직원 급여현황***");
		System.out.println();
		System.out.println("사원명\t기본급\t자녀수\t초과시간\t가족수당\t시간수당\t총급여");
		System.out.println("========================================================================================");
	}
	
}


public class L15_SawonInstanceScanner {
	
	public static void writeEmp(Emp[] emp) {
		//제목부터 출력
		Emp.showTitle();
		
		for(Emp e:emp) {
			System.out.println(e.getsName()+"\t"
			+ e.getgPay()+"\t"+e.getfSu() +"\t"+ e.gettSu() 
			+ "\t" + e.getFamilySudang() 
			+ "\t"+ e.getTimeSudang() +"\t" + e.getTotalPay());
			
		}
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int inwon;
		Emp [] emp;//배열 형태의 생성자
		
		System.out.println("입력할 직원수는?");
		inwon = Integer.parseInt(sc.nextLine());
		
		
		//배열할당
		emp = new Emp[inwon];//index가 inwon만큼인 배열타입 생성자 emp?
		
		//인원수만큼의 데이터를 입력
		//(위에서 입력한 '직원수(inwon)만큼 for문으로 뺑뺑이 돌림)
		for(int i=0;i<inwon ;i++) {
			
			//emp[i] = new Emp();
			System.out.print("이름: ");
			String name = sc.nextLine();
			System.out.print("기본급: ");
			int pay = Integer.parseInt(sc.nextLine());
			System.out.print("자녀수: ");
			int fs = Integer.parseInt(sc.nextLine());
			System.out.print("초과시간: ");
			int ts = Integer.parseInt(sc.nextLine());
			
			emp[i] = new Emp(name, pay, fs, ts);
			
			
			//setter로 emp클래스에 데이터 넣기
			//emp[i].setsName(name);
			//emp[i].setgPay(pay);
			//emp[i].setfSu(fs);
			//emp[i].settSu(ts);
					
			System.out.println();
			
		}	
		
		//출력
		writeEmp(emp);
		
	}

}
