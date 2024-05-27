package boot.mvc.mini;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.data.*","boot.mvc.mini"})
@MapperScan("boot.data.mapper")
public class SpringMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMiniProjectApplication.class, args);
	}

}
