package day0108;

public class L10_For {
	public static void main(String[] args) {
		int i=1;
		for(; i<=10; i++) {
			System.out.print(i+" ");
		}
		
		//==================
		System.out.println("\nfor문 빠져나온 i의 값: " + i);
		int a = 10;
		for(; a<=50; a+=5) {
			System.out.print(a + " ");
		}
		System.out.println("\n빠져나온 a값: " + a);
		
		
		System.out.println("1~10까지 숫자중에서 짝수만 출력");
		for(int n=1; n<=10; n++) {
			if(n%2==0) {
				System.out.print(n+ " ");
			}
		}
		System.out.println();
		
		
		System.out.println("1~10까지 숫자중에서 짝수만 출력:continue");
		for(int h=1;h<=10;h++) {
		
			//짝수만 출력 =>홀수를 건너뛰어 =>홀수조건:skip
			if(h%2==1) {
				continue;
			}
			System.out.print(h + " ");
		}
	}
}
