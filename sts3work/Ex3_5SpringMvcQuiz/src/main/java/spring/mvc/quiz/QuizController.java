package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Controller�� �Ἥ bean�� ��Ͻ����ִ� ���̴�.
@Controller
public class QuizController {
    
	//���� ��� �������ֱ�
    @GetMapping("/happy")
    public String happy() {
        return "nice"; // happy ��û�� nice.jsp�� ������
    }

    // "/"�־�ǰ� ����ȴ�.
    @GetMapping("/hello")
    public String hello(Model model) {
        
    	model.addAttribute("msg","2������_�޼����� �̹��� ���");
    	
    	return "hello"; // hello ��û�� hello.jsp�� ������
    }

    @GetMapping("/nice/like")
    public String niceLike(Model model) {
    	
    	
		model.addAttribute("name", "������");
		model.addAttribute("hp", "010-2222-4444");
		model.addAttribute("addr", "����� ������");
    	
        return "happy"; // nice/like ��û�� happy.jsp�� ������
    }
}
