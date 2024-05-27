package boot.mvc.mini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.data.*"})//모든 패키지 등록
@MapperScan("boot.data.mapper") //mapper 등록
public class SpringMiniProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMiniProject2Application.class, args);
	}

}
