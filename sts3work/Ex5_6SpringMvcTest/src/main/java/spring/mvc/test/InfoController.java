package spring.mvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoController {

	@GetMapping("/info/myform")
	public String myform() {
		//String�� �ǹ� : �������ϰڽ��ϴٴ� ��
		
		return "info/infoform"; //WEB-INF/info/infoform.jsp
	}

	@PostMapping("/info/read")
	public String result(@ModelAttribute("dto") InfoDto dto) {
		
		return "info/infowrite";
	}
	
}
