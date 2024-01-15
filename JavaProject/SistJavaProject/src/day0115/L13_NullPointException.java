package day0115;

import java.util.Date;

public class L13_NullPointException {

	Date date;//선언o,생성x

	public void write() {
		int y,m,d;

		try {
			y = date.getYear() - 1900;
			m = date.getMonth() + 1;
			d = date.getDate();
			System.out.println(y+"년"+m+"월"+d+"일 입니다.");
		
		}catch(NullPointerException e) {
			e.printStackTrace();//이거 주석처리 안하면 왜 예외인지 알려준다.
			System.out.println("객체 생성을 안했어요." + e.getMessage());
			
		}
	}

	public static void main(String[] args) {
		L13_NullPointException nullex = new L13_NullPointException();
		nullex.write();
		System.out.println("**프로그램 정상종료");

	}
}
