package boot.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.InfoDto;

@Controller
public class FormReadController {

	@PostMapping("/sist/read1")
	public ModelAndView result1(@RequestParam String name,
			@RequestParam int java,
			@RequestParam int spring) {
		
		ModelAndView model = new ModelAndView();
		//request에 저장
		model.addObject("name",name);
		model.addObject("java",java);
		model.addObject("spring",spring);
		
		model.addObject("tot",java+spring);
		model.addObject("avg",(java+spring)/2.0);
		
		
		//포워드
		model.setViewName("result/result1");
		
		return model;
		
	}
	
	
	@PostMapping("/sist/show2")
	public String result2(@ModelAttribute("dto") InfoDto dto) {
		
		
		return "result/result2";
	}
	
	@PostMapping("/sist/write3")
	//map으로 읽을 경우 폼의 name이 key값으로 
	//입력값이 value값으로 저장
	public ModelAndView result3(@RequestParam Map<String, String> map) {
		
		ModelAndView model = new ModelAndView();
		
		// Store the parameters in the model
	    model.addObject("name", map.get("name"));
	    model.addObject("blood", map.get("blood"));
	    model.addObject("buseo", map.get("buseo"));
	    
	    //포워드
	    model.setViewName("result/result3");
		
		return model;
		
	}
	
}
