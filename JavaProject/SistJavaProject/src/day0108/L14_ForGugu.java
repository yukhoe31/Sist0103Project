package day0108;

import java.util.Scanner;

//book 128: 구구단
public class L14_ForGugu {

	public static void main(String[] args) {

		//기본 구구단
		System.out.println("[기본 구구단]");
		// 중첩 for문을 이용한 구구단(2~9단)
		for(int dan=2; dan<=9; dan++) {//단
			System.out.println("***"+ dan+"단***");
			for(int j=1; j<=9; j++) {
				System.out.println(dan + "X" + j + "=" + (dan*j));
			}
			System.out.println();
		}


		System.out.println("[break문을 이용한 구구단]");	
		//break문을 이용한 구구단
		loop1:
			for(int dan = 2; dan<= 9; dan++) {
				for(int j=1;j<=9; j++) {
					if(j==5) {
						//break; //현재의 반복문을 빠져나가 상위의 dan++으로 이동.
						break loop1; 
						//이름을 명시하여 여러반복문이 빠져나가는 것도 가능(루프네임:)
					}
					System.out.println(dan + "*" + j + "=" + dan*j);
				}
				System.out.println();
			}


		System.out.println();
		
		
		
		System.out.println("Q.단을 입력하면 해당 단이 나오게 해주세요.");
		Scanner sc = new Scanner(System.in);
		int dan;

		while(true) {
			System.out.println("단을 입력하세요.");
			dan= sc.nextInt();

			//종료조건
			if(dan==0) {
				System.out.println("프로그램을 종료!!!");
				break;
			}

			//잘못입력한 경우
			if(dan<2 || dan>9) {
				System.out.println("2~9단 까지만 가능. 재입력해주세요.");
				continue;
			}

			//구구단 출력
			System.out.println("["+dan+"단]");
			for(int i = 1; i<=9;i++) {
				System.out.printf("%d X %d = %2d\n",dan , i ,(dan*i));
			}				
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("가로 방향으로 구구단 출력");

		for(int d=2;d<=9;d++) {
			System.out.print("["+ d +"단]\t");

		}

		System.out.println();
		System.out.println();

		for(int i=1;i<=9;i++) {
			for(int d=2;d<=9;d++) {
				System.out.print(d+"x"+i+"="+ d*i +"\t");
			}
			System.out.println();
		}



	}

}
