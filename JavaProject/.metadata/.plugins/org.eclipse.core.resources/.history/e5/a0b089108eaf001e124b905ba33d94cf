package day0110;

import java.util.Scanner;

public class L02_ArraySearchName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//L01과 같은 문제이지만, 이번엔 숫자가 아니라 이름이다.
		
		String [] names = {"홍길동","김길동","최길동","고길동",
				"이길동","박길동","유길동","조길동","부길동","신길동"};

		boolean flag;
		Scanner sc = new Scanner(System.in);
		String name;
		
		while(true) {
			System.out.println("검색할 이름 입력");
			name = sc.nextLine();
			
			//0입력시 종료
			if(name.equalsIgnoreCase("q")) {
				System.out.println("프로그램 종료!!");//q,Q상관없이 종료가능
				break;
			}
			
			flag = false; //찾으면 true로 변경
			
			//값 찾기
			for(int i =0;i<names.length;i++) {
				if(name.equals(names[i])) {
					flag=true;
					System.out.println(i+1+"번째에서 검색");
				}				
			}
			
			if(!flag) {//flag == false
				System.out.println(name +"는 데이터에 없습니다.");
			}
			
			
		}
		
		
	}

}
