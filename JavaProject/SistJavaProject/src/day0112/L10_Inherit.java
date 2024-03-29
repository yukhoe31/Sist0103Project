package day0112;

//부모
class Work{
	
	void goodmorning() {
		System.out.println("안녕하세요~~~");
	}
	
	public void process() {
		System.out.println("아무것도 안하고 있음!!!");
	}
}
//////////////////////////자식들
class Food1 extends Work{
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		//super.process();
		System.out.println("***음식담당***");		
	}
}
///////////////////////////
class Clean extends Work{
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		//super.process();
		System.out.println("***청소담당***");	
	}
}
////////////////////////////
class Sing extends Work{
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		//super.process();
		System.out.println("***노래담당***");
	}
}

/////////////////////////////
public class L10_Inherit {

	public static void main(String[] args) {
		
		//다형성->하나의 변수로 작업해야할 때가 있다.
		//부모클래스로 선언하고 자식클래스로 생성하는 경우
		Work work = null; //선언
		
		work = new Food1();		
		work.goodmorning();
		work.process();
		System.out.println();
		
		work = new Clean();		
		work.goodmorning();
		work.process();
		System.out.println();
		
		work = new Sing();		
		work.goodmorning();
		work.process();
		System.out.println();
		
	}
}
