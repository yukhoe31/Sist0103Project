package day0116;

public class L01_ExceptionReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("안녕하세요.");
		System.out.println("3초뒤에 저는 갑니다.");
		
		try {
			Thread.sleep(3000);//3초 카운트 후 아래내용 출력
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***잘가~~~***");

	}

}
