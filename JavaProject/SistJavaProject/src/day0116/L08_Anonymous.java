package day0116;

import javax.swing.event.ListDataListener;

abstract class AbEx{
	
	abstract public void dataAdd();
	abstract public void dataList();
	
	
}
/////////////////////////


/////////////////////////
public class L08_Anonymous {
	
	//아래처럼 쓸거 아니면 extends AbEx라고 위에 쓰면 된다.
	AbEx ab1 = new AbEx() {
		// TODO Auto-generated method stub
		@Override
		public void dataList() {
			System.out.println("데이터를 출력합니다.");
		}
		
		@Override
		public void dataAdd() {
			System.out.println("데이터를 추가합니다.");
		}

	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L08_Anonymous anon = new L08_Anonymous();
		anon.ab1.dataAdd();
		anon.ab1.dataList();
		
	}

}
