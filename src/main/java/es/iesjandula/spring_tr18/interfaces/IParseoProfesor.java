/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.interfaces;

import java.util.Scanner;

import es.iesjandula.spring_tr18.errors.ApplicationError;
/**
 * This class interface parse the teachers data of a CSV file
 * @author Manuel Canio Gil
 * @version 1.3.1
 */
public interface IParseoProfesor 
{
    void parsearFicheroProfesor(Scanner scanner) throws ApplicationError;
}
