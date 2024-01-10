package day0110;

//실행결과
/*
 * 대한민국
 * 123456-1234567
 * 감자바
 */


class Korean{
	
	//인스턴스 final필드 선언(국가, 주민번호)
	final String nation = "대한민국";
	final String ssn = "123456-1234567";
	
	//인스턴스 필드 선언(이름)
	String name;
	
	//생성자 선언
	public Korean(String ssn, String name){
		//this.nation = nation;
		//this.ssn = ssn;
		
		
	}
	
}


/////////////////////////////
public class L18_Book253 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Korean k1= new Korean("1234-123456","감자바");//잘못된 ssn을 다시 적어 넣어도 바뀌지 않는다.
		
	    System.out.println(k1.nation);
	    System.out.println(k1.ssn);
	    System.out.println(k1.name);
	    
	    
	}

}
