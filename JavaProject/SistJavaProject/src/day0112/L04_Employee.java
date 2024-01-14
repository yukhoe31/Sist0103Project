package day0112;

//부모클래스
public class L04_Employee {
	
	String empName;
	int salary;
	
	//생성자
	public L04_Employee(String name, int sal) {
		this.empName = name;
		this.salary = sal;
	}
	
	//메서드
	public String getEmployee() {
		return empName +" | " + salary;
	}
}
