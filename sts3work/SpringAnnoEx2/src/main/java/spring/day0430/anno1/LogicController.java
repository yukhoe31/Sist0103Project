package spring.day0430.anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic")  //id�� logic�� �ȴ�
public class LogicController {

	@Autowired  //�ڵ�����
	DaoInter inter;
	public LogicController() {
		// TODO Auto-generated constructor stub
	}
	
	public LogicController(MyDao dao) {
		this.inter=dao;
	}
	
	//insert
	public void insert(String str)
	{
		inter.insertData(str);
	}
	//delete
	public void delete(String num)
	{
		inter.deleteData(num);
	}
}
