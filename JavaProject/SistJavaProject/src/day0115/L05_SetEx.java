package day0115;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class L05_SetEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(5);
		set1.add(4);
		set1.add(15);
		set1.add(25);
		set1.add(35);
		set1.add(35);
		
		System.out.println("갯수: " + set1.size());
		
		System.out.println("[출력_#1: 순서x, 중복x]");
		for(int n:set1) {
			System.out.printf("%5d", n);
		}
		System.out.println();
		
		
		System.out.println("[출력_#2]");
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {//다음 내용이 있는 경우만 while문 반복
			System.out.printf("%5d", iter.next());
		}
		System.out.println();
		
		
		System.out.println("[출력_#3]");
		Object [] ob = set1.toArray();
		for(int i=0;i<ob.length; i++) {
			System.out.printf("%5d", ob[i]);
		}

	}

}
