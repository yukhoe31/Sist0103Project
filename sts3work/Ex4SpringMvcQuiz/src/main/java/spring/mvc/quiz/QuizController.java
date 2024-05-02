package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
    
    @GetMapping("happy")
    public String happy() {
        return "nice"; // happy 요청을 nice.jsp로 포워드
    }

    @GetMapping("hello")
    public String hello() {
        return "hello"; // hello 요청을 hello.jsp로 포워드
    }

    @GetMapping("nice/like")
    public String niceLike() {
        return "happy"; // nice/like 요청을 happy.jsp로 포워드
    }
}
