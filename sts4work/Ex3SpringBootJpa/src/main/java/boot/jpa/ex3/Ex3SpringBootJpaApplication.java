package boot.jpa.ex3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"myshop.data"})
@EntityScan("myshop.data") //dto인식
public class Ex3SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex3SpringBootJpaApplication.class, args);
	}

}
