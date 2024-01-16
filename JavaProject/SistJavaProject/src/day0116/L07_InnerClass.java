package day0116;

class OuterObject{
	
	int a =10;
	static int b =20;
	
	class InnerObject{
		
		int c = 30;
		
		public void write() {
			System.out.println("외부 인스턴스 변수 a= "+a);
			System.out.println("외부 정적변수 b= " + b);
			System.out.println("내부 인스턴스 변수 c= "+c);
		
		}
	}
	
	static class InnerObject2{
		
		int d = 40;
		static int e = 50;//class앞에 static없으면 오류난다.
		
		public void write2() {
			//System.out.println("외부 인스턴스 변수 a= "+a);//외부 일반변수 접근 불가
			System.out.println("외부 정적변수 b= " + b);
			System.out.println("내부 일반변수 d= " + d);
			System.out.println("내부 정적변수 e= " + e);
		}
	}
}
////////////////
public class L07_InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OuterObject.InnerObject ob = new OuterObject().new InnerObject();
		ob.write();
		
		System.out.println();
		//OuterObject.InnerObject2 ob2 = new OuterObject().new InnerObject2();
		//InnerObject 클래스가 static이라서 위의 방법으로는 생성 안된다.
		OuterObject.InnerObject2 ob2 = new OuterObject.InnerObject2();
		ob2.write2();
		

	}
}
