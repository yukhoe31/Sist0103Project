package day0105;

public class IfOperTest_11 {

	public static void main(String[] args) {
		
		// if문과 삼항연산자 비교
		
		//1.if문
		int score =88;
		char grade; //학점
		
		if(score >= 90) {
			grade = 'A';
		}else if(score >= 80) {
			grade = 'B';
		}else if(score >= 70) {
			grade = 'C';
		}else if(score >= 80) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		System.out.println("학점은 " + grade + "입니다.");
		
		
		//2.삼항연산자
		int score2 = 77;
		char grade2 = score2 >= 90 ? 'A':
			    		score2 >= 80 ? 'B':
			    			score2 >= 70 ? 'C':
			    				score2 >= 60 ? 'D': 'F';
			    				
	    System.out.println("학점은 " + grade2 + "입니다.");
	    
	    //switch문
	    switch(score/10) {
	    	case 10:
	    	case 9:
	    		grade = 'A';
	    		break;
	    	case 8:
	    		grade = 'B';
	    		break;
	    	case 7:
	    		grade = 'C';
	    	    break;
	    	case 6:
	    		grade = 'D';
	    		break;
	    	default:
	    		grade = 'F';
	    }
	    System.out.println("학점은 " + grade+"입니다.");

	    
	}
}
