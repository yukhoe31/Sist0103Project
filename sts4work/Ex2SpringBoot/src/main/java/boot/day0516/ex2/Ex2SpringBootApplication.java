package boot.day0516.ex2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"boot.mvc.*"})
public class Ex2SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex2SpringBootApplication.class, args);
	}

}
