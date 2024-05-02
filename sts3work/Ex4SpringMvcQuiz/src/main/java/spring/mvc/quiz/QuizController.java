package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
    
    @GetMapping("happy")
    public String happy() {
        return "nice"; // happy ��û�� nice.jsp�� ������
    }

    @GetMapping("hello")
    public String hello() {
        return "hello"; // hello ��û�� hello.jsp�� ������
    }

    @GetMapping("nice/like")
    public String niceLike() {
        return "happy"; // nice/like ��û�� happy.jsp�� ������
    }
}
