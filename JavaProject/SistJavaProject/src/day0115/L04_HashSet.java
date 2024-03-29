package day0115;

//Set: 집합과 유사(순서x, 중복x, null은 하나만 사용 가능)
//HashSet: 순서를 유지하지 않는 데이터 집합, 중복 불가
//구현클래스: 인덱스 없음
//Set인터페이스를 구현하려면 HashSet
//<E> 제네릭: 타입을 명시하면 그 이외의 타입을 넣으면 오류난다.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class L04_HashSet {

	public static void main(String[] args) {
		
		//컬렉션은 크기가 가변적이므로 배열의 고정형을 보완해 준다.
		//배열은 크기가 고정인데, 컬렉션은 그렇지 않다.
		
		//컬렉션 생성
		//Set인터페이스 내에 HashSet클래스가 존재.
		//인터페이스<데이터타입> *특정이름* = new 인터페이스내의클래스<데이터타입>();
		//new가 있으면 99프로 "클래스 객체 생성"
		//앞(Set=인터페이스): 컬렉션 생성  뒤(new 포함): HashSet 클래스 객체 생성
		Set<String> set1 = new HashSet<String>();
		//set1안에 String만을 담겠다_
		//Set은 인터페이스 이므로 생성이 안됨.
		//그러므로 그걸 구현한 클래스인 HashSet으로 생성
		
		set1.add("사과");
		set1.add("오렌지");
		set1.add("배");
		set1.add("사과");//중복 -> 개수에 포함안됨 ->Set은 중복허용안되므로
		set1.add("키위");
		set1.add("바나나");
		
		System.out.println("데이터 갯수: " + set1.size());
		
		//------
		System.out.println("[출력_#1]");
		
		for(String s:set1) {
			System.out.println(s);
		}
		
		//-------
		System.out.println("[출력_#2]");
		//Iterator 사용하기
		Iterator<String> iter= set1.iterator();
		
		while(iter.hasNext()) {//데이터가 더이상 없으면 false반환
			String s = iter.next();
			System.out.println(s); //다음으로 이동함과 동시 데이터 반환
		}
		
		//-------
		System.out.println("[출력_#3]");
		Object [] ob = set1.toArray();
		for(int i=0; i<ob.length; i++) {
			System.out.println(ob[i]);
		}
		
		//모든 데이터 삭제
		set1.clear();
		
		System.out.println();
		
		//확인
		if(set1.isEmpty()) {
			System.out.println("Set타입 안에 데이터가 없다.");
		}else {
			System.out.println("Set타입 안에 데이터가 있다.");
		}
		

	}

}
