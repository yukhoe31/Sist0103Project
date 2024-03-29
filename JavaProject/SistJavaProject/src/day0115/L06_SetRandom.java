package day0115;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class L06_SetRandom {

	public static void main(String[] args) {
		
		// Set,random을 이용해서 1~45의 서로다른난수 6개	
		Random r = new Random();
		//Set컬렉션 ==>  HashSet 클래스생성
		Set<Integer> set = new HashSet<Integer>();
		
		while(true) {
			int n = r.nextInt(45) + 1;//1~45
			set.add(n);
			
			if(set.size()==6) {
				break;
			}		
		}
		
		System.out.println("[출력_#1]");
		for(int s : set) {
			System.out.printf("%5d", s);
		}
		System.out.println();
		
		
		System.out.println("[출력_#2]");
		Iterator<Integer> iter = set.iterator();
		
		while(iter.hasNext()) {//다음 내용이 있는 경우만 while문 반복
			System.out.printf("%5d", iter.next());
		}
		System.out.println();
		
		
		System.out.println("[출력_#3]");
		Object [] ob = set.toArray();
		for(int i=0;i<ob.length; i++) {
			System.out.printf("%5d", ob[i]);
		}
		
		
	}

}
