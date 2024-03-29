package day0108;

public class L11_Sum {

	public static void main(String[] args) {
		// 반복문에서 합계구하기
		
		//for문
		int sum=0;
		for(int i=1; i<=10; i++) {
			
			sum += i; //sum = sum + i;//누적		
		}
		System.out.println("1~10까지의 합: "+ sum +"입니다.");
				
		//while문
		int n=1;
		int tot=0;
		while(n<=10) {
			
			//tot에 n을 누적시킨다.
			tot += n;//tot = tot + n;
			n++;
		}
		System.out.println("1~10까지의 합: "+ tot +"입니다.");
		
		//==========
		System.out.println("for문으로 1~10까지중 2씩 증가할경우의"
				+ " 합계를 구하시오.");
		
		int total = 0;
		for(int a = 1; a<=10; a+=2) {
			total += n;
		}
		
		System.out.println("총합계는 " + total);		
	}
}
