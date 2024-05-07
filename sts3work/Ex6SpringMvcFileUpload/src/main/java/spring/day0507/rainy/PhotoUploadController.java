package spring.day0507.rainy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class PhotoUploadController {

	//업로드폼1로 가기
	@GetMapping("/")
	public String uploadform1() {
		
		return "uploadform1";
	}
	
}
