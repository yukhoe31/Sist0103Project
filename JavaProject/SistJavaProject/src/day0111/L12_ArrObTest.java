package day0111;

class MyInfo{

	private String name;
	private String mbti;
	private int age;

	//생성자
	public MyInfo(String name, String mbti, int age) {
		this.name = name;
		this.mbti = mbti;
		this.age = age;
	}

	//메서드
	//아래 메서드는 static을 쓴다...변수 없으니까
	public static void showTitle() {
		System.out.println("이름\tMBTI\t나이");
		System.out.println("========================");
	}
	public void showInfo() {
		System.out.println(name+"\t" + mbti + "\t" + age +"세");
	}

}

////////////////
public class L12_ArrObTest {

	public static void main(String[] args) {

		//생성자 3개 생성
		MyInfo [] my1 = {
				new MyInfo("이효리" ,"ENTP", 26),
				new MyInfo("이상순" ,"ISFJ", 33),
				new MyInfo("이영자" ,"ENFP", 28)

		};

		MyInfo.showTitle();
		
		//방법1:
		for(MyInfo m:my1) {
			m.showInfo();
		}

		//방법2:
		/*
		for(int i=0;i<my1.length;i++) {
			my1[i].writeInfo();
		}
		 */

	}

}
