package spring.di.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex5Main {
	
	public static void main(String[] args) {
		
		ApplicationContext app5 = new ClassPathXmlApplicationContext("appContext5.xml");
		
		Emp emp1 = (Emp)app5.getBean("emp1");
		emp1.writeEmp();
		
	}

}
