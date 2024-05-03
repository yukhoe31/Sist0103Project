package spring.mvc.may;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/form")
	public String form1()
	{
		return "board/writeform";
	}
	
	@PostMapping("/process")
	public ModelAndView process(@RequestParam String name,
			@RequestParam String date,
			@RequestParam String gender,
			/*required�� true�� �⺻��,�׸��� ��� ������ �ȳ��� �Ϸ��� false*/
			@RequestParam(required = false) String msg,
			/*�Ǵ� defaultValue�� �ָ�ȴ�*/
			@RequestParam(name = "pageNum",defaultValue = "1")int currentPage)
	{
		ModelAndView model=new ModelAndView();
		
		model.addObject("name", name);
		model.addObject("date", date);
		model.addObject("gender", gender);
		model.addObject("msg", msg);
		model.addObject("currentPage", currentPage);
		
		//������
		model.setViewName("board/result");
		
		return model;
	}
	
	
	
	
	@GetMapping("/result2")
	public String result2(Model model)
	{
		model.addAttribute("myimg1", "../image/a01.png");
		model.addAttribute("title", "���� ���� ����� ĳ����");
		
		return "board/result2";
	}
	
	//list.jsp�� �����常
	@GetMapping("/list")
	public String list()
	{
		return "board/list";
	}
	
}
