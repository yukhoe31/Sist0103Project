package spring.mvc.quiz2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Quiz2Controller {

	//처음 등장할 화면 : testform
	//주소창에 보이는 주소: http://localhost:8080/quiz2/
	@GetMapping("/")
	public String sawonform()
	{
		return "testform";
	}
	
	//dto이용후 나타낼 화면 : sawoninfo
	//주소창에 보이는 주소: http://localhost:8080/quiz2/info
	@PostMapping("/info")
	public ModelAndView readinfo(@ModelAttribute SawonDto dto)
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("dto", dto);
		model.setViewName("sawoninfo");
		
		return model;
	}
}
