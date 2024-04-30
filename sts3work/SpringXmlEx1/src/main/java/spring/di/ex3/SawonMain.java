package spring.di.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {
	
	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("appContext3.xml");
		
		Sawon sawon = app.getBean("sa", Sawon.class);
		sawon.writeData();
		
		System.out.println();
		
		Sawon sawon2 = app.getBean("sa2", Sawon.class);
		sawon2.writeData();
		
	
	}

}
