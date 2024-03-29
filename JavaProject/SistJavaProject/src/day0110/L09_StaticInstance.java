package day0110;

//static 변수는 메모리에 한번 할당되면 프로그램이 종료될 때 해제되는 변수이다.
//메모리에 한번 할당이므로 여러객체가 해당메모리를 공유..효율이 좋아진다.(조회수 증가 static)


public class L09_StaticInstance {
	
	static int count = 0; //static 있을때랑 없을때 결과가 다르다.
	
	//생성자
	public L09_StaticInstance() {
		count++;
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//객체변수는 항상 독립적이므로 count는 서로다른 메모리를 가지므로 증가하지 않는다.
		//static은 공유하므로 증가한다.
		//static은 아래처럼 생성하는걸 권장하진 x, 그냥 시험삼아 쓴것.
		//평소에는 인스턴스랑 헷갈려서 생성하지 않아.
		L09_StaticInstance s1 = new L09_StaticInstance();
		L09_StaticInstance s2 = new L09_StaticInstance();

	}

}
