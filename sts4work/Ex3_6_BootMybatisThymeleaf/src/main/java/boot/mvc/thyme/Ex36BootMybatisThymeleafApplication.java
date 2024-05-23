package boot.mvc.thyme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"myshop.*"})
@MapperScan({"myshop.mapper"})
public class Ex36BootMybatisThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex36BootMybatisThymeleafApplication.class, args);
	}

}
