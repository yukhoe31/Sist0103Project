package day0112;

//클래스를 객체 생성할때는 자동으로 부모 => 자식순 :그래샤 자식이 부모의 멤버를 사용할수 있기 때문

//메인클래스
public class L04_MainEmp {

	public static void main(String[] args) {
		
		L04_Manager man = new L04_Manager("김선아",2800000,"경영기획부");
		System.out.println(man.getEmployee()); //name | sal | depart
		
	}

}
