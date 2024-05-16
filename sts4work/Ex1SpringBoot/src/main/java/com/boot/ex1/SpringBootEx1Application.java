package com.boot.ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"boot.test","hello.boot","sist.boot"})
public class SpringBootEx1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEx1Application.class, args);
	}

}
