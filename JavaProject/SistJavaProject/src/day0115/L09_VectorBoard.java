package day0115;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class L09_VectorBoard {

	//List컬렉션...변수list  = Vector클래스<L09_Board클래스>생성
	List<L09_Board> list = new Vector<L09_Board>();
	//제네릭 유형을 클래스로 지정했으므로 데이터를 꺼내고 받을때도 클래스
	//*제네릭 유형이란? < >안에 들어갈 데이터타입.위의 경우는 class
	
	//입력메서드
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		String writer, subject, content;

		System.out.println("작성자명?");
		writer = sc.nextLine();
		System.out.println("제목?");
		subject = sc.nextLine();
		System.out.println("내용?");
		content = sc.nextLine();

		//명시적 생성자의 생성
		L09_Board data = new L09_Board(writer, subject, content);
		list.add(data);

		System.out.println("현재 데이터 갯수: "+list.size()+"개");

	}

	//출력메서드
	public void writeData() {
		System.out.println("**IT 교재 목록**");
		System.out.println("=====================");
		for(int i=0;i<list.size();i++) {
			L09_Board b = list.get(i);
			System.out.println("No. "+(i+1) +"\t작성자: "+ b.getWriter());
			System.out.println("제목: "+b.getSubject());
			System.out.println("내용: "+b.getContent());
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L09_VectorBoard vt = new L09_VectorBoard();
		Scanner sc = new Scanner(System.in);
		int n;

		while(true) {
			System.out.println("1.입력   2.전체출력   9.종료");
			n = Integer.parseInt(sc.nextLine());

			if(n==1) {
				vt.inputData();
			}else if(n==2) {
				vt.writeData();
			}else if(n==9){
				System.out.println("**종료합니다.**");
				break;
			}
		}


	}

}
