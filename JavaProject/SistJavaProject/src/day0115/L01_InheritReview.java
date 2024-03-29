package day0115;

///////////////////
interface InterAA{
	
	public void play();//선언부만 존재, 구현부는 없다.
}

///////////////////
interface InterBB extends InterAA{
	
	public void draw();
	
}
//////////////////
class InterImple implements InterAA,InterBB{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("나는 게임을 한다.");
	}

	@Override
	public void draw() {
		System.out.println("나는 그림을 그린다.");
		
	}
	
}



////////////////////////
public class L01_InheritReview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//
		InterImple imp1 = new InterImple();
		imp1.draw();
		imp1.play();
		
		System.out.println();
		
		//다형성으로 출력
		System.out.println("다형성으로 출력");
		
		InterAA aa = new InterImple();
		//aa.draw(); //오류난다.
		aa.play();
		
		InterBB bb = new InterImple();
		bb.draw();
		bb.play();

	}
}
