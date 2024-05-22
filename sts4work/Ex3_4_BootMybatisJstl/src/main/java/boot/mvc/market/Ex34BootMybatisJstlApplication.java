package boot.mvc.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"data.*"})
@MapperScan({"data.mapper"})
public class Ex34BootMybatisJstlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex34BootMybatisJstlApplication.class, args);
	}

}
