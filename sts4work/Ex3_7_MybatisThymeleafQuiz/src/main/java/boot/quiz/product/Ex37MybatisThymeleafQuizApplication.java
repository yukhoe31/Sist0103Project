package boot.quiz.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"product.*"})
@MapperScan({"product.mapper"})
public class Ex37MybatisThymeleafQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex37MybatisThymeleafQuizApplication.class, args);
	}

}
