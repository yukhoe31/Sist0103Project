package day0111;

/*
 * 메서드: 접근제한자(public) + 지정예약어(static) + 결과형리턴값(void) + 메서드명()
 * 반복적인 코드를 줄여 코드의 관리가 쉽다.
 * 하나의 메서드는 한가지 기능만 수행하도록 작성하는 게 좋다.
 * 
 * 오버로딩:
 * 자바의 한 클래스 내에 
 * 이미 사용하려는 이름과 같은 이름을 가진 메소드가 있더라도 
 * 매개변수의 개수 또는 타입이 다르면, 
 * 같은 이름을 사용해서 메소드를 정의할 수 있다.
 *  
 */

public class L14_ExMethod {

	//메서드 종류(1): 리턴값o, 패러미터 x
	public static boolean aaa() {

		return false;//반드시 위에 적힌대로 boolean값으로 리턴한다.
	}

	public static int bbb() {
		return 11;
	}

	//메서드 종류(2): 리턴값o, 패러미터o
	public static int ccc(int x, int y) {

		int sum = x + y;
		return sum;
	}

	//메서드는 오버로딩이 가능하다.
	//sum:덧셈
	public static int sum(int a, int b) {
		System.out.print("1번째 sum함수 호출: ");
		return a+b;
	}
	public static double sum(int a, double b) {
		System.out.print("2번째 sum함수 호출: ");
		return a+b;

	}
	public static double sum(double a, int b) {
		System.out.print("3번째 sum함수 호출: ");
		return a+b;
	}
	public static double sum(double a, double b) {
		System.out.print("4번째 sum함수 호출: ");
		return a+b;
	}

	//mul:곱셈
	public static int mul(int a, int b) {

		return a*b;
	}

	//제곱
	public static double square(double a) {
		System.out.println("");
		double result = a*a;
		return result;
	}

	//메서드 종류(4): 리턴값x, 패러미터o
	//나누기
	public static void divide(int a, int b) {

		if(b == 0) {
			System.out.println("0으로 나눌 수는 없습니다.");

		}else {
			System.out.println("나눗셈의 결과: " + (a/(double)b));
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean a = aaa();
		System.out.println("a = " + a);

		int b = bbb();
		System.out.println("b = " + b);

		int c = ccc(20,30);
		System.out.println("c = " + c);

		//sum
		System.out.println(sum(3,4));
		System.out.println(sum(3,4.4));
		System.out.println(sum(3.3,4));
		System.out.println(sum(3.3,4.4));

		//mul
		System.out.println("10*20의 곱: "+mul(10,20));
		System.out.println("4.5의 제곱: "+square(4.5));

		//divide
		divide(4,2);
		divide(1,2);
		divide(3,0);

	}

}
