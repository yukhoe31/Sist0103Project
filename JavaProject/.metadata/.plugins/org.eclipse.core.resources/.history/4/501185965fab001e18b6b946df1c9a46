package day0104;

import java.util.Calendar;//Calendar 클래스를 이식

public class CalAge_12 {

	public static void main(String[] args) {
		//실행단계에서 변수 입력하여 이름,출생년도 를 입력하여 나이를 출력
		
		//1.import
		Calendar calendar = Calendar.getInstance();
		
		//2.변수
		String name = args[0];
		int curYear = calendar.get(calendar.YEAR); //현재 년도
		//Integer.parseInt : String ==> int로 변환
		int myYear = Integer.parseInt(args[1]);
		
		//3.계산
		int myAge = curYear - myYear;
		
		//4.출력
		System.out.println("이름: " + name);
		System.out.println("출생년도 : " + myYear);
		System.out.println("나이: " + myAge+"세");

	}

}
