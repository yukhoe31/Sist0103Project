package day0105;

import java.util.Scanner;

public class QuizOper_14 {
	public static void main(String[] args) {
		/*
		 * (점수에 대하 조건은 90점 이상: 매우잘함
		 * 80점이상: 잘함 70점이상:좀더 노력할것
		 * 이름을 입력해주세요
		 * 김민아
		 * 자바시험점수를 입력해주세요
		 * 88
		 * 
		 * --------------------------------
		 * 김민아님의 시험평가는 잘함 입니다.
		 */
		
		Scanner sc= new Scanner(System.in);
		
		
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		
		System.out.println("자바시험점수를 입력해주세요");
		int score = sc.nextInt();
		
		String grade = "꽝";
		
		//1.if문
		/*
		if(score>=90) {
			grade = "매우잘함";
		}else if(score>=80){
			grade = "잘함";
		}else if(score>=70){
			grade = "좀 더 노력할 것";
		}
		*/
		
		//2.삼항 연산자
		grade = (score>=90)?"매우잘함":
			    (score>=80)?"잘함":
			    (score>=70)?"좀더 노력할 것":"꽝";	
				
		
		System.out.println("=====================");
		System.out.printf("%s님의 시험평가는 %s입니다.",name, grade);
		System.out.println("\n=====================");
		
		
		
	}

}
