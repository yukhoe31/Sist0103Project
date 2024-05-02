package spring.day0502.shop;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexFormController {

	@GetMapping("/data/myform")
	public String form1()
	{
		return "form1";
	}
	
	//get�������
	@GetMapping("/data/read1")
	public ModelAndView read1(@RequestParam String name,
			@RequestParam int age,
			@RequestParam(value = "msg",defaultValue = "�����Ϸ纸������~~") String msg)
	{
		ModelAndView model=new ModelAndView();
		
		//request������
		model.addObject("name", name);
		model.addObject("age", age);
		model.addObject("msg", msg);
		
		//������
		model.setViewName("getProcess");
		
		return model;
	}
	
	@PostMapping("/data/read2")
	public ModelAndView read2(@ModelAttribute ShopDto dto)
	{
		ModelAndView model=new ModelAndView();
		model.addObject("dto", dto);
		model.setViewName("postProcess");
		
		return model;
	}
	
	@PostMapping("/data/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
		
		String sang=map.get("sang");
		String price=map.get("price");
		String color=map.get("color");
		
		String data=sang+"�� ������ "+price+"�̸� ������ "+color+"�Դϴ�";
		
		model.addObject("data", data);
		model.setViewName("mapProcess");
		return model;
	}
	
}
