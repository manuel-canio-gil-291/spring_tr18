/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18;

import java.io.File;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import es.iesjandula.spring_tr18.controller.AulaInformaticaController;
import es.iesjandula.spring_tr18.controller.CarritoPCsController;
import es.iesjandula.spring_tr18.controller.CarritoTabletsController;
import es.iesjandula.spring_tr18.controller.ErrorPageController;
import es.iesjandula.spring_tr18.controller.IndexController;
import es.iesjandula.spring_tr18.controller.JsonRestController;
import es.iesjandula.spring_tr18.controller.ProfesorController;
import es.iesjandula.spring_tr18.controller.WebController;
import es.iesjandula.spring_tr18.errors.ApplicationError;
import es.iesjandula.spring_tr18.interfaces.IParseoAulaInformatica;
import es.iesjandula.spring_tr18.interfaces.IParseoCarritoPCs;
import es.iesjandula.spring_tr18.interfaces.IParseoCarritoTablets;
import es.iesjandula.spring_tr18.interfaces.IParseoProfesor;
import es.iesjandula.spring_tr18.models.AulaInformatica;
import es.iesjandula.spring_tr18.models.CarritoPCs;
import es.iesjandula.spring_tr18.models.CarritoTablets;
import es.iesjandula.spring_tr18.models.Profesor;
import es.iesjandula.spring_tr18.repositories.IAulaInformaticaRepository;
import es.iesjandula.spring_tr18.repositories.ICarritoPCsRepository;
import es.iesjandula.spring_tr18.repositories.ICarritoTabletsRepository;
import es.iesjandula.spring_tr18.repositories.IProfesorRepository;
import es.iesjandula.spring_tr18.utils.Constants;

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
	AulaInformaticaController.class,
	IndexController.class,
	JsonRestController.class,
	ErrorPageController.class
})
public class Launcher implements CommandLineRunner, IParseoProfesor, IParseoAulaInformatica, IParseoCarritoPCs, IParseoCarritoTablets
{
	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	public IProfesorRepository profesorRepository;
	@Autowired
	public IAulaInformaticaRepository aulaInformaticaRepository;
	@Autowired
	public ICarritoPCsRepository carritoPCsRepository;
	@Autowired
	public ICarritoTabletsRepository carritoTabletsRepository;
	/**
	 * Spring boot runtime
	 * @param args with the input arguments
	 */
	public static void main(String[] args) 
	{
		SpringApplication.run(Launcher.class, args);
	}

	@Transactional(readOnly = false)
	public void run(String... args) throws Exception 
	{
		parsearFicheroProfesor(new Scanner(new File("src/main/resources/profesor.csv")));
		parsearFicheroAulaInformatica(new Scanner(new File("src/main/resources/aula_informatica.csv")));
		parsearFicheroCarritoPCs(new Scanner(new File("src/main/resources/carrito_pcs.csv")));
		parsearFicheroCarritoTablets(new Scanner(new File("src/main/resources/carrito_tablets.csv")));
	}

	@Override
	public void parsearFicheroProfesor(Scanner scanner) throws ApplicationError 
	{
		try 
        {
            scanner.nextLine();

            while(scanner.hasNextLine())
            {
                String lineaDelFichero = scanner.nextLine();

                String[] lineaDelFicheroTroceada = lineaDelFichero.split(Constants.DELIMITADOR_CSV);
                
                Profesor profesor = new Profesor();
                profesor.setNombre(lineaDelFicheroTroceada[0]);
                profesor.setApellidos(lineaDelFicheroTroceada[1]);

                this.profesorRepository.saveAndFlush(profesor);
            }
        } 
        catch (Exception exception) 
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_CSV_FILE, exception);
            LOGGER.error(applicationError);
        }
		
	}

	@Override
	public void parsearFicheroAulaInformatica(Scanner scanner) throws ApplicationError 
	{
		try 
		{
			scanner.nextLine();

			while(scanner.hasNextLine())
			{
				String lineaDelFichero = scanner.nextLine();

                String[] lineaDelFicheroTroceada = lineaDelFichero.split(Constants.DELIMITADOR_CSV);

				AulaInformatica aulaInformatica = new AulaInformatica();
				aulaInformatica.setNumeroAula(Integer.valueOf(lineaDelFicheroTroceada[0]));
				aulaInformatica.setPlanta(Integer.valueOf(lineaDelFicheroTroceada[1]));

				this.aulaInformaticaRepository.saveAndFlush(aulaInformatica);
			}
		} 
		catch (Exception exception) 
		{
			ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_CSV_FILE, exception);
            LOGGER.error(applicationError);
		}
		
	}

	@Override
	public void parsearFicheroCarritoPCs(Scanner scanner) throws ApplicationError 
	{
		try 
        {
            scanner.nextLine();

            while(scanner.hasNextLine())
            {
                String lineaDelFichero = scanner.nextLine();

                String[] lineaDelFicheroTroceada = lineaDelFichero.split(Constants.DELIMITADOR_CSV);
                
                CarritoPCs carritoPCs = new CarritoPCs();
				carritoPCs.setNumeroPcs(Integer.valueOf(lineaDelFicheroTroceada[0]));
				carritoPCs.setPlanta(Integer.valueOf(lineaDelFicheroTroceada[1]));
				carritoPCs.setSistemaOperativo(lineaDelFicheroTroceada[2]);

				this.carritoPCsRepository.saveAndFlush(carritoPCs);
            }
        } 
        catch (Exception exception) 
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_CSV_FILE, exception);
            LOGGER.error(applicationError);
        }
		
	}

	@Override
	public void parsearFicheroCarritoTablets(Scanner scanner) throws ApplicationError 
	{
		try 
        {
            scanner.nextLine();

            while(scanner.hasNextLine())
            {
                String lineaDelFichero = scanner.nextLine();

                String[] lineaDelFicheroTroceada = lineaDelFichero.split(Constants.DELIMITADOR_CSV);
                
                CarritoTablets carritoTablets = new CarritoTablets();
				carritoTablets.setNumeroTablets(Integer.valueOf(lineaDelFicheroTroceada[0]));
				carritoTablets.setPlanta(Integer.valueOf(lineaDelFicheroTroceada[1]));

				this.carritoTabletsRepository.saveAndFlush(carritoTablets);
            }
        } 
        catch (Exception exception) 
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_CSV_FILE, exception);
            LOGGER.error(applicationError);
        }
	}
	
}
