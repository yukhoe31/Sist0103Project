package spring.day0507.rainy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class PhotoUploadController {

	//���ε���1�� ����
	@GetMapping("/")
	public String uploadform1() {
		
		return "uploadform1";
	}
	
}
