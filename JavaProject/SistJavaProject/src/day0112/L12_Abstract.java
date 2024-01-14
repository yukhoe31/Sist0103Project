package day0112;

import java.util.Scanner;

///////////////////////추상부모클래스
abstract class Board{
	public abstract void play();//선언부만 있고, 구현부는 없다.
}
//////////////////////추상자식클래스
class Insert extends Board{
	@Override//재정의
	public void play() {
		System.out.println("입력합니다.");
	}	
}
/////////////////////추상자식클래스
class Select extends Board{
	@Override//재정의
	public void play() {
		System.out.println("출력합니다.");	
	}
}
/////////////////////추상자식클래스
class Update extends Board{
	@Override//재정의
	public void play() {
		System.out.println("수정합니다.");
	}
}
/////////////////////추상자식클래스
class Delete extends Board{

	@Override//재정의
	public void play() {
		System.out.println("삭제합니다.");
	}
}
////////////////////메인클래스
public class L12_Abstract {
	
	public static void main(String[] args) {
		
		
		// 다형성으로 생성 메서드 출력
		/*
		Board board;
		
		board = new Insert();
		board.play();//nullpointExcepton: 생성도 안했는데 호출했을때 나오는 오류.
		
		board = new Select();
		board.play();
		
		board = new Update();
		board.play();
		
		board = new Delete();
		board.play();
		*/
		
		//Board board = new Board();//추상클래스 new로 생성못함.
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		Board board = null; //부모클래스 선언(null로 초기화해주지 않으면 오류난다.)
		
		while(true) {
			System.out.println("1.쓰기   2.조회   3.수정   4.삭제");
			num = sc.nextInt();
			
			switch(num) {
			case 1:
				board = new Insert();//자식클래스 생성
				break;
			case 2:
				board = new Select();//자식클래스 생성
				break;
			case 3:
				board = new Update();//자식클래스 생성
				break;
			case 4:
				board = new Delete();//자식클래스 생성
				break;
			default:
				System.out.println("종료합니다");
				System.exit(0); //강제종료
				
			}
			
			board.play();
		}
	}
}
