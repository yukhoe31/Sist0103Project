package boot.jpa.ex3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"myshop.data"})
@EntityScan("myshop.data") //dto인식
@EnableJpaRepositories("myshop.data")//dao인식
public class Ex3SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex3SpringBootJpaApplication.class, args);
	}

}
