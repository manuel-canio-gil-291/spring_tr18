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
 * This class interface parse the TIC classrooms data of a CSV file
 * @author Manuel Canio Gil
 * @version 1.3.0
 */
public interface IParseoAulaInformatica 
{
    void parsearFicheroAulaInformatica(Scanner scanner) throws ApplicationError;    
}
