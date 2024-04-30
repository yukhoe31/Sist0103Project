package spring.di.ex5;

import spring.di.ex3.SawonData;

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

		System.out.println("사원명: ");
		System.out.println("급여: " +info.getPay());
		System.out.println("직급: " );
		System.out.println("부서명: " +info.getBuseo());
		
	}

}
