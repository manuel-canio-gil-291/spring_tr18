package es.iesjandula.spring_tr18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.iesjandula.spring_tr18.controller.AulaInformaticaController;
import es.iesjandula.spring_tr18.controller.CarritoPCsController;
import es.iesjandula.spring_tr18.controller.CarritoTabletsController;
import es.iesjandula.spring_tr18.controller.ProfesorController;
import es.iesjandula.spring_tr18.controller.WebController;

/**
 * This class starts the application
 */
@SpringBootApplication
@EnableJpaRepositories
@Configuration
@ComponentScan(basePackageClasses = {
	WebController.class, 
	ProfesorController.class,
	CarritoTabletsController.class,
	CarritoPCsController.class,
	AulaInformaticaController.class
})
public class Launcher {
	/**
	 * Spring boot runtime
	 * @param args with the input arguments
	 */
	public static void main(String[] args) 
	{
		SpringApplication.run(Launcher.class, args);
	}
}
