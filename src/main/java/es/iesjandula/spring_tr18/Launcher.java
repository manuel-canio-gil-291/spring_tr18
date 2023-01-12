package es.iesjandula.spring_tr18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.iesjandula.spring_tr18.controller.WebController;

@SpringBootApplication
@EnableJpaRepositories
@Configuration
@ComponentScan(basePackageClasses = {WebController.class})
public class Launcher {
	public static void main(String[] args) 
	{
		SpringApplication.run(Launcher.class, args);
	}
}
