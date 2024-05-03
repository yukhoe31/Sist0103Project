package spring.mvc.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class InfoController {

	@GetMapping("/myform")
	public String form1()
	{
		return "infoform";
	}
	

	//dto√≥∏Æ
	@PostMapping("/result")
	public String process1(@ModelAttribute InfoDto dto)
	{
		
		return "infowrite";
	}

	
	
}
