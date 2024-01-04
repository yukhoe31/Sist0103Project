package day0104;

import java.util.Calendar;//Calendar 이식

public class Calendar_11 {

	public static void main(String[] args) {
		
		//Calendar로부터 모든 instance값을 가져와서 cal에 넣기.
		Calendar cal = Calendar.getInstance(); 
		
		//cal에서 특정 instance(YEAR,MONTH,DATE,DAY_OF_MONTH,HOUR_OF_DAY)를 get하기.
		System.out.println("지금은 " + cal.get(cal.YEAR) + "년도 입니다.");
		//월은 0부터 시작하기 때문에 +1을 해줘야한다.
		System.out.println("지금은 " + (cal.get(cal.MONTH)+1) + "월 입니다.");
		System.out.println("지금은 " + cal.get(cal.DATE)+"일 입니다.");
		System.out.println("지금은 " + cal.get(cal.DAY_OF_MONTH)+ "일 입니다.");
		System.out.println("시간: " + cal.get(cal.HOUR_OF_DAY) +"시"+ cal.get(cal.MINUTE) +"분");
		

	}
}
