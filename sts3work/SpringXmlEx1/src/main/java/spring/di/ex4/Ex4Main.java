package spring.di.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex4Main {
	
	public static void main(String[] args) {
		
		ApplicationContext app1 = new ClassPathXmlApplicationContext("appContext4.xml");
		
		Sungjuk sj = (Sungjuk)app1.getBean("sj");
		sj.writeSungjuk();
		
	}

}
