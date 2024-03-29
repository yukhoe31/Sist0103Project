package day0104;

public class QuizDataType_10 {

	public static void main(String[] args) {
		// 변수는 args를 이용할 것
		
		/*
		 * 학생명 : 김선호 님
		 * 지역 : 부산
		 * 나이 : 23세
		 * 
		 * ==================
		 * 김선호님의 자바점수는 88점, 오라클점수는 77점, 총 165점입니다.
		 */
		
		//1.변수선언
		String name = args[0];
		String local = args[1];
		//args는 기본적으로 String이므로 Wrapper형변환을 이용한다. (int)<-이 형변환은 안먹혀!!
		//형변환 없이 쓰려면 String age = args[2]; 처럼 age를 그냥 문자열로 생각해서 써도 된다.
		int age = Integer.parseInt(args[2]); 
		int java = Integer.parseInt(args[3]);
		int oracle =Integer.parseInt(args[4]);
		
		//2.계산(값이 우선 들어와야 계산이 되므로 변수선언 후에 계산을 해야함. 순서가 중요!)
		int total = java + oracle;
		
		//3.출력
		System.out.printf("학생명: %s님\n",name);
		System.out.printf("지역: %s\n",local);
		System.out.printf("나이: %d세\n",age);
		System.out.println("\n=======================================================");
		System.out.printf("%s님의 자바점수는 %d점, 오라클점수는 %d점, 총 %d점입니다.",name,java,oracle,total);
		//아래처럼 써도 위의 문장과 똑같이 출력된다.
		//System.out.println(name+"님의 자바점수는 "+java+"점, 오라클점수는 "+oracle+"점, 총 "+total+"점입니다.");
	}

}
