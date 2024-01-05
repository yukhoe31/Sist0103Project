package day0105;

public class book123_22 {
	
	//grade에 따라 스위치된 점수: 
	//내가 A등급->점수환산:100점
	//내가 B등급->점수환산:80점
	//내가 그 외 등급->점수환산:60점

	public static void main(String[] args) {
		
		String grade = "B";
		
		int score1 = 0;
		switch(grade) {
		case "A":
			score1 = 100;
			break;
		case "B":
			int result = 100 - 20;//왜 굳이 이렇게??->그냥 책에서 변수 연습용으로 쓴든...
			score1 = result;
			break;
		default:
			score1 = 60;	
		}
		System.out.println("score1: " + score1);
	}
}
