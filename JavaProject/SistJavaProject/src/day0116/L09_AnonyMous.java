package day0116;

abstract class AbstObj{
	
	abstract public void dataIn();
	abstract public void dataOut();
	
}
///////////////////
class SubAbst extends AbstObj{

	@Override
	public void dataIn() {
		// TODO Auto-generated method stub
		System.out.println("상속_데이터입력");
	}

	@Override
	public void dataOut() {
		// TODO Auto-generated method stub
		System.out.println("상속_데이터출력");
	}
	
	
}


//////////////////
public class L09_AnonyMous {
	
	//익명내부클래스
	AbstObj ab1 = new AbstObj() {

		@Override
		public void dataIn() {
			// TODO Auto-generated method stub
			System.out.println("익명내부클래스_데이터입력");
		}

		@Override
		public void dataOut() {
			// TODO Auto-generated method stub
			System.out.println("익명내부클래스_데이터출력");
		}
		
	};
	
	SubAbst sub = new SubAbst();
	
	public static void main(String[] args) {
		
		L09_AnonyMous an = new L09_AnonyMous();
		
		
		//익명내부 클래스 
		an.ab1.dataIn();
		an.ab1.dataOut();
		
		System.out.println();
		
		//상속받은 클래스
		SubAbst sub1 = new SubAbst();
		sub1.dataIn();
		sub1.dataOut();
		
		System.out.println();
		//main함수 밖에서 선언
		an.sub.dataIn();
		an.sub.dataOut();
		
	}
}
