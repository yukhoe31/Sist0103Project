package spring.day0502.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {

	@GetMapping("/")
	public String start()
	{
		return "redirect:login/form";
	}
	
	@GetMapping("/login/form")
	public String form()
	{
		return "form";
	}
	
	//������
	@GetMapping("/login/read")
	public String process(Model model,@RequestParam(value = "myid") String id,
			@RequestParam(value = "mypass")String pass)
	{
		
		model.addAttribute("id", id);
		
		//��й�ȣ�� 1234�� �α��μ���,�ƴϸ� ����
		String msg="";
		if(pass.equals("1234"))
			msg="�α��μ���!!";
		else
			msg="�α��ν���!!";
		
		model.addAttribute("msg", msg);
		
		return "result";
	}
}
