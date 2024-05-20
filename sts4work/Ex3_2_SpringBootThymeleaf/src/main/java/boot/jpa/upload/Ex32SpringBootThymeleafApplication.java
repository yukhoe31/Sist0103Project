package boot.jpa.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"data.*"})
public class Ex32SpringBootThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex32SpringBootThymeleafApplication.class, args);
	}

}
