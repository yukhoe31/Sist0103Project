package spring.last.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JumunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext1.xml");
		
		OrderController order=(OrderController)app.getBean("orderController");
		
		order.jumunInsert("�䰡��Ʈ", 35000, "��");
		order.jumunDelete("2");
		order.jumunSelect("�Ʒ�", 45000, "ȭ��Ʈ");
	}

}
