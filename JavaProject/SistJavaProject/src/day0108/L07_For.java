package day0108;

public class L07_For {

	public static void main(String[] args) {
		// while문과 for문을 비교
		
		
		System.out.println("**while문으로 10~0 출력**");
		int i=10;
		while(i >= 0) {
			System.out.print(i-- +" ");
		}
		System.out.println();
		
		
		System.out.println("**for문으로 10~0 출력**");
		for(int a=10; a>=0; a--) {
			System.out.print(a+ " ");
		}
		System.out.println();
		
		
		System.out.println("**for문 1~10 종료**");
		for(int a=1; a<=10; a++) {
			System.out.print(a+" ");
		}System.out.println("종료");
		
		
		System.out.println("**while문 1~10 종료**");
		int b = 1;
		while(true) {
			System.out.print(b++ +" ");
			if(b>10) {
				break;
			}
		}
		System.out.println("종료");
		
		
		System.out.println("**for문 1,4,7,10**");
		for(int c=1; c<=10; c+=3) {
			System.out.print(c + " ");
		}
		System.out.println("종료");
		
		
		System.out.println("**for문 5 4 3 2 1**");
		for(int j=5; j>=1; j--) {
			System.out.print(j + " ");
		}
		System.out.println("종료");
		
		
		System.out.println("**while문 5 4 3 2 1**");
		int k = 5;
		while(k>0) {
			System.out.print(k-- + " ");	    
		}
		System.out.println("종료");
		
		
		int m;//for문 밖에서도 변수m을 쓰고 싶을때 for문 밖에서 선언.
		System.out.println("**for문 HelloJava를 5번 반복**");
		for(m=1; m<5; m++) {
			System.out.print("HelloJava" + " ");
		}
		System.out.println();
				
	}

}
