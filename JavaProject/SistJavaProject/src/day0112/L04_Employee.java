package day0112;

public class L04_Employee {
	
	String empName;
	int salary;
	
	public L04_Employee(String name, int sal) {
		this.empName = name;
		this.salary = sal;
	}
	
	//메서드
	public String getEmployee() {
		return empName +"," + salary;
	}
}
