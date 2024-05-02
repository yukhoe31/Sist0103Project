package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Controller를 써서 bean에 등록시켜주는 것이다.
@Controller
public class QuizController {
    
	//매핑 경로 지정해주기
    @GetMapping("/happy")
    public String happy() {
        return "nice"; // happy 요청을 nice.jsp로 포워드
    }

    // "/"있어도되고 없어도된다.
    @GetMapping("/hello")
    public String hello(Model model) {
        
    	model.addAttribute("msg","2번문제_메세지와 이미지 출력");
    	
    	return "hello"; // hello 요청을 hello.jsp로 포워드
    }

    @GetMapping("/nice/like")
    public String niceLike(Model model) {
    	
    	
		model.addAttribute("name", "이진우");
		model.addAttribute("hp", "010-2222-4444");
		model.addAttribute("addr", "서울시 강남구");
    	
        return "happy"; // nice/like 요청을 happy.jsp로 포워드
    }
}
