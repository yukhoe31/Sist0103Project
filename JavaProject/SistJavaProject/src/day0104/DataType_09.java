package day0104;

public class DataType_09 {

	public static void main(String[] args) {
		//args를 이용한 연산
		
		//변수선언
	    int java=Integer.parseInt(args[0]); //String인 args[0] --> 정수
	    int jsp = Integer.parseInt(args[1]);
	    int spring = Integer.parseInt(args[2]);
	    
	    //계산
	    int tot = java + jsp + spring;
	    int count = 3; //3과목을 의미하는 변수
	    
	    double avg1 = tot/3; //결과는 무조건: int(정수)
	    double avg2 = (double)tot/count;//결과: double(실수)
	    
	    System.out.println(avg1);
	    System.out.println(avg2); 
	    
	    //printf를 이용해서
	    //총점은 88로 출력되도록
	    System.out.printf("java는 %d, jsp는 %d, spring은 %d\n", java,jsp,spring);
	    System.out.println("총점=" + tot);
	    
	    System.out.printf("평균=%.2f\n",avg1);
	    
	    

	}

}
