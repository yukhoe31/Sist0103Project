package day0116;

import java.util.Scanner;

/*  throws vs. throw
 *  throws는 메서드에서 발생할 수 있는 예외를 선언하는 것이고,
 *  throw는 실제로 예외를 발생시키는 것입니다.
 */

//강제예외발생 throw
//Exception클래스는 자바에 기본적으로 내장된 클래스이다.
class UserException extends Exception{
	
	public UserException(String msg) {
		super(msg);//Exception클래스 생성자 통해 정식 메세지로 등록
	
	}
}

////////////////////////////
public class L03_ThrowException {
	
	public static void process() throws UserException {
		Scanner sc = new Scanner(System.in);
		int age = 0;
		
		//나이가 10~59가 아니면 UserException 강제발생
		System.out.println("나이를 입력해주세요:");
		age = sc.nextInt();
		
		if(age<10 || age>=60) {
			throw new UserException("우리모임의 나이는 10~59세입니다.");		
		}else {
			System.out.println("당신은 " +age+"세 이므로 멤버로 등록이 가능합니다.");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			process();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			System.out.println("오류메세지: " + e.getMessage());
		}
		
		System.out.println("**정상종료**");
		
	}

}
