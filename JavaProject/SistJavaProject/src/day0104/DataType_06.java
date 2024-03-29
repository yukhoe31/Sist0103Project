package day0104;

//초보 추천 순서 : 변수선언 -> 계산 -> 출력
public class DataType_06 {
	//boolean flag; <-(메서드 밖에서)이렇게 주면 false로 인식
	public static void main(String[] args) {
		
		// 기본 자료형 8개
		
		// 1.논리형(boolean ->true,false)
		boolean flag = false;//<-(메서드안에서)줄때는 '대입'부분이 없으면 오류남.
		
		// 2.문자형(char)
		//반드시 하나의 문자, 16바이트 유니코드값 표현
		//2바이트 문자하나
		//기본적으로 정수형, 아스키코드로 변경이 가능
		//''로 표현
		char ch = '가';
		
		// 3.정수형(byte, short, int, long)
		byte a = -128; //1byte : -128~127
		short b = 32000; //16bit 
		int c = 670000; //32bit
		long d = 100; //64bit 뒤에 L,l을 붙여야 long인지 int인지를 의미할 수 있기 때문에.
		
		// 4.실수(float, double)
		float f = 3.1234f; //32bit 뒤에 f를 붙이지않으면 double을 의미
		double dou = 23456.1234567; //64bit 소수점가진 숫자의미 double이 기본
		
		//출력
		System.out.println("flag="+flag);
		System.out.println("문자형 ch=" +ch);
		
		System.out.println("정수 a=" +a);
		System.out.println("정수 b=" +b);
		System.out.println("정수 c=" +c);
		System.out.println("정수 d=" +d);		
	}
}
