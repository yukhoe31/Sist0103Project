package spring.day0430.anno1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogicMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app1=new ClassPathXmlApplicationContext("annoContext1.xml");
		
		LogicController logic1=(LogicController)app1.getBean("logic");
		
		logic1.insert("������ xml ������");
		logic1.delete("3");
	}

}
