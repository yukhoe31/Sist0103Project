package spring.di.ex2;

public class MyInfo {
	
	String name;
	int age;
	String addr;
	
	//����� ������
	public MyInfo(String name,int age,String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
				
	}
	
	public String toString() {
		return "MyInfo [name="+name+",age="+age+", addr="+addr+"]";
		
	}

}
