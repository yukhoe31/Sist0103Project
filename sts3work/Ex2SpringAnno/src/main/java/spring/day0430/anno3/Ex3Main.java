package spring.day0430.anno3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex3Main {
	
public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("annoContext1.xml");
		

		TestController con = (TestController)app.getBean("testController");
		con.insert("이효리");
		con.delete("3");
		con.select("이상순");
				
	}

}
