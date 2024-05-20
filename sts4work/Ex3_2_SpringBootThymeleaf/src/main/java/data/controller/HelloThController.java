package data.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.ShopDto;

@Controller
public class HelloThController {
	
	List<ShopDto> list = new ArrayList<>();
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}

	
	@GetMapping("/hello1")
	public String hello1(Model model) {
		
		System.out.println("hello1 controller");
		
		model.addAttribute("message","Have a Nice Day!");
		model.addAttribute("today",new Date());
		
		ShopDto dto = ShopDto.builder()
				.num(100)
				.sangpum("요가매트")
				.su(10)
				.dan(25000)
				.color("purple")
				.build();
		
		model.addAttribute("dto",dto);
		
		return "hello1";
	}

}
