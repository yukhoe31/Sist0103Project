package spring.day0507.rainy;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.day0507.data.ShopDto;

@Controller
@RequestMapping("/shop")
public class FormDataController {

	@GetMapping("/form1")
	public String form1()
	{
		return "day0507/form1";
	}
	
	@PostMapping("/read1")
	public ModelAndView read1(@RequestParam String irum,
			@RequestParam String gender,
			@RequestParam String addr)
	{
		ModelAndView model=new ModelAndView();
		
		//�𵨿� ���
		model.addObject("irum", irum);
		model.addObject("gender", gender);
		model.addObject("addr",addr);
		//������
		model.setViewName("day0507/result1");
		return model;
	}
	
	@GetMapping("/form2")
	public String form2()
	{
		return "day0507/form2";
	}
	
	@PostMapping("/read2")
	public String read2(@ModelAttribute ShopDto dto) //shopDto�� �𵨿� ����
	{
		return "day0507/result2";
	}
	
	
	@GetMapping("/form3")
	public String form3()
	{
		return "day0507/form3";
	}
	
	@PostMapping("/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("sang", map.get("sang"));
		model.addObject("color", map.get("color"));
		model.addObject("price", map.get("price"));
		model.addObject("image", map.get("image"));
		
		model.setViewName("day0507/result3");
		
		return model;
	}
	
}
