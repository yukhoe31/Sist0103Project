package day0115;

import java.util.List;
import java.util.Vector;

public class L08_ListEx {
	
	public static void write(String title, List<String> list) {
		System.out.println("**"+ title + "**");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(i+ ":"+ list.get(i));
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		
		/* List컬렉션(인터페이스)내의 클래스 :Vector, ArrayList, LinkedList
		 * Vector, ArrayList_순차, 중복데이터
		 * 메서드
		 * get(index)_리스트내의 지정된 위치값 요소를 돌려준다.
		 * toArray() _리스트내의 모든요소를 순서대로 포함하고 배열에 넣어준다.(반환형: Object [])
		 * isEmpty() _Vector가 비었는지 않았는지(반환형: boolean)
		 */
		
		//배열
		String [] data = {"햄버거","피자","파스타"};
		
		//배열의 데이터를 리스트에 넣기
		//List인터페이스 => Vector클래스로 선언(인터페이스는 선언이 불가)
		List<String> list = new Vector<String>();
		
		for(String s:data) {//data배열내의 s들을 차례대로 list내에 add한다.
			list.add(s);
		}
		
		//write(String title, List<String> list);
		write("초기배열데이터", list);
		
		
		System.out.println("1번 인덱스 삭제해보기");
		list.remove(1);//인덱스 1 지우기
		write("삭제후결과", list);
		
		
		System.out.println("리코타샐러드 추가하기");
		list.add("리코타샐러드");//맨뒤에 추가
		write("추가후 데이터", list);
		
		
		System.out.println("1번인덱스 파스타를 스파게티로 변경");
		list.set(1, "스파게티");//인덱스 1을 변경
		write("변경후 출력", list);
		
		
		System.out.println("**전체삭제**");
		list.clear();//전체 삭제
		System.out.println("삭제후 사이즈"+ list.size());
		
		
		
	}

}
