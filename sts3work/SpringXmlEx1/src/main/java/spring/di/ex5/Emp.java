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

		System.out.println("***����***");
		System.out.println("ȸ���: " +empname);
		System.out.println("ȸ����ġ: " +emploc);

		System.out.println("�����: "+info.getSawonname());
		System.out.println("�޿�: " +info.getPay());
		System.out.println("����: " +info.getLevel());
		System.out.println("�μ���: " +info.getBuseo());
		
	}

}
