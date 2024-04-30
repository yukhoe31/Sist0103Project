package spring.day0430.anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic")  //id가 logic이 된다.
public class LogicController {
	
	//기본생성자
	public LogicController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired //자동주입
	DaoInter inter;
	
	public LogicController(MyDao dao) {
		
		this.inter = dao;
		
	}
	
	//insert
	public void insert(String str) {
		
		inter.insertData(str);
		
	}
	
	//delete
	public void delete(String num) {
		
		inter.deleteData(num);
	}
	

}



