package boot.mvc.guest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.guest.*"})
@MapperScan({"boot.guest.mapper"})
public class Ex38BootMybatisGuestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex38BootMybatisGuestApplication.class, args);
	}

}
