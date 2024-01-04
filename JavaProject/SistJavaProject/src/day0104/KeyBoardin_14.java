package day0104;

import java.util.Scanner;

public class KeyBoardin_14 {

	public static void main(String[] args) {
		
		//키보드 입력에 필요한 Scanner 클래스를 import
		//1.import
		Scanner sc = new Scanner(System.in);//★중요!!!
		
		//2.변수선언
		String name;
		int age;
		
		//3.입력
		System.out.print("이름을 입력해 보세요==>");
	    name = sc.nextLine(); //한줄을 문자로 읽어온다. (공백사용가능)
	    
	    System.out.print("나이를 입력해 보세요==>");
	    //age = sc.nextInt(); //숫자로 읽어온다.
	    //숫자입력후 엔터누르면 그 엔터가 키보드 버퍼로 저장되어 다음 문자열 읽을 때 먼저 읽어버리는 현상발생
	    ///그래서 다음문자열을 읽기 전에 그 엔터를 읽어서 없애버리기.(sc.nextLine())
	    /*
	    키보드 버퍼는 키 입력이 처리되기 전에 
	    해당 키 입력을 유지하는 데 사용되는 컴퓨터 메모리 섹션입니다. 
	    */
	    age = Integer.parseInt(sc.nextLine());//문자열을 읽어오고->정수로 형변환
	    
	    System.out.println("당신이 사는 지역은?");
	    String city = sc.nextLine(); //
	    
	    //4.최종출력
	    System.out.println(name +"님의 나이는 "+ age+"세이고 " + city +"지역에 살아요.");
	    
	    

	}

}
