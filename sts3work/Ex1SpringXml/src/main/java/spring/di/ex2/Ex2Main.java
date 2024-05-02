package spring.di.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=new ClassPathXmlApplicationContext("appContext2.xml");
		
		//MyInfo
		MyInfo my=(MyInfo)context.getBean("my");
		
		System.out.println(my.toString());//.toString()�� ������ �ڵ�ȣ��Ǵ� �޼���
		System.out.println(my); 
		
		//Person
		Person p=(Person)context.getBean("person");
		p.writeData();
	}

}
