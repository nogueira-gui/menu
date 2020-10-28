package br.com.guilhermenogueira.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "br.com.guilhermenogueira.menu")
@EntityScan(basePackages = "br.com.guilhermenogueira.menu.model")
@ComponentScan({"br.com.guilhermenogueira.menu.controller"})
public class MenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}

}
