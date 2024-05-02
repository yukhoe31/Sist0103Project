package spring.di.ex5;

public class Emp {

	SawonInfo info;

	private String empname;
	private String emploc;

	
	public Emp(SawonInfo info) {
		// TODO Auto-generated constructor stub
		super();		
		this.info = info;	
	}




	public void writeEmp() {

		System.out.println("***정보***");
		System.out.println("회사명: " +empname);
		System.out.println("회사위치: " +emploc);

		System.out.println("사원명: "+info.getSawonname());
		System.out.println("급여: " +info.getPay());
		System.out.println("직급: " +info.getLevel());
		System.out.println("부서명: " +info.getBuseo());
		
	}

}
