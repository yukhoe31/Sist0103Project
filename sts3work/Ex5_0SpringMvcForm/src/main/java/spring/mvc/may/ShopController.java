package spring.mvc.may;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {

	@GetMapping("/shop/dtoform")
	public String form1()
	{
		return "shop/formdto";
	}
	
	@GetMapping("/shop/mapform")
	public String form2()
	{
		return "shop/formmap";
	}
	
	//dto贸府
	@PostMapping("/shop/process1")
	public String process1(@ModelAttribute ShopDto dto)
	{
		
		return "shop/dtoresult";
	}
	
	//map贸府
	@PostMapping("/shop/process2")
	public ModelAndView process2(@RequestParam Map<String, String> map)
	{
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("sang", map.get("sang"));
		mview.addObject("su", map.get("su"));
		mview.addObject("dan", map.get("dan"));
		mview.addObject("color", map.get("color"));
		
		mview.setViewName("shop/mapresult");
		
		return mview;
	}
	
}
