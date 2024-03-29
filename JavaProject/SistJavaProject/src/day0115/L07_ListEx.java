package day0115;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class L07_ListEx {

	//List: 순서o, 중복o
	public static void main(String[] args) {
		// 1.순차적으로 데이터 들어간다.
		// 2.중복데이터도 허용한다.
		// 3.처음생성시 일정한 갯수로 생성되는데 
		//   그 이상의 데이터를 넣으면 자동으로 공간이 늘어난다.
		
		//List<String> list = new Vector<String>();
		Vector<String> list = new Vector<String>();
		//생성자가 디폴트인 경우, 기본할당크기 10
		System.out.println("초기데이터갯수: "+ list.size());
		System.out.println("초기할당크기: "+ list.capacity());

		list.add("장미");
		list.add("장미");//중복 허용
		list.add("수국");
		list.add("프리지아");
		list.add("안개꽃");
		list.add("해바라기");
		list.add("장미");
		list.add("프리지아");
		list.add("안개꽃");
		list.add("해바라기");
		list.add("장미");
		
		System.out.println();
		System.out.println("초기데이터갯수: "+ list.size());
		System.out.println("초기할당크기: "+ list.capacity());

		System.out.println("[출력_#1]");
		for(int i=0;i<list.size();i++) {
			String s = list.get(i);
			System.out.print(s+" ");
		}
		
		System.out.println("[출력_#2]");
		for(String s:list) {
			System.out.print(s+" ");
		}
		System.out.println();
		
		System.out.println("[출력_#3]");
		
		/*
		 * iterator(): Set 인터페이스를 구현한 구체적인 Set 클래스의 인스턴스에서 
		 * iterator 메서드를 호출하여, 해당 Set에 대한 Iterator를 얻습니다. 
		 * Iterator를 통해 컬렉션의 요소에 접근할 수 있게 됩니다.
		 * 
		 * Iterator<Integer> iter: 얻어진 Iterator를 저장하기 위한 변수 iter를 
		 * 선언하고 있습니다. 이후에는 iter를 사용하여 Set의 요소를 순회하고 접근할 수 있습니다.
		 */

		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		
		System.out.println("[출력_#4]");
		Object [] ob = list.toArray();
		for(int i =0;i<ob.length;i++) {
			String s = (String)ob[i];//ob->String형태로 배열에 넣기.
		}
		
	}

}
