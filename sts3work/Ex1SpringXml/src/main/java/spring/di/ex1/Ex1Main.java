package spring.di.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		System.out.println("1.�ڹٹ�� ������ ȣ��");
		MessageInter m1=new Message1();
		m1.sayHello("����");
		
		MessageInter m2=new Message2();
		m2.sayHello("ö��");
		
		System.out.println("2.��������� ������ ȣ��");
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
		
		MessageInter m3=(Message1)context.getBean("msgBean1"); //���1
		m3.sayHello("ȣ����");
		
		MessageInter m4=context.getBean("msgBean2", Message2.class);//���2
		m4.sayHello("�缮��");
		
	}

}
