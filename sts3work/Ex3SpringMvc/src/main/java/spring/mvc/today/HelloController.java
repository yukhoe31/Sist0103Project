package spring.mvc.today;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	//@RequestMapping(value = "/",method = RequestMethod.GET)
	//���� ������ �� ���� �Ʒ� ª���ŷ� ��� ��밡��(5��������)
	/*
	@GetMapping("/")
	public String hello1(Model model) {
		
		model.addAttribute("name", "ȫ�浿");
		model.addAttribute("addr", "����� ������ ���ﵿ");
		
		return "result1";
		
	}
	*/
}
