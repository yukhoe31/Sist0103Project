package day0116;

public class L13_StringToken {

	public static void main(String[] args) {
		//문자열을 특정기호로 분라하는 방법들
		String str = "red,yellow,cyan,grey,pink";
		
		System.out.println("String객체의 split을 이용한 분리");
		String [] arrColors = str.split(",");
		System.out.println("총 " +arrColors.length +"개");
		
		
	}

}
