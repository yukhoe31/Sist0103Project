package boot.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.data.mapper.SmartMapperInter;

@Controller
@RequestMapping("/smart")
public class SmartController {

	@Autowired
	SmartMapperInter mapperInter;
	
	@GetMapping("/form")
	public String form() {
		return "/smart/smartform";
	}
	
	@GetMapping("/list")
	public String list() {
		return "/smart/smartlist";
	}
	
}
