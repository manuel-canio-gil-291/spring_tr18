/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.errors;
/**
 * This is a class that throws an error message and a throwable exception 
 * while the application is requesting a petition
 * @author Manuel Canio Gil
 * @version 1.3.1
 */
public class ApplicationError extends Exception 
{
    /**
     * Empty constructor
     */
    public ApplicationError()
    {
        super();
    }
    /**
     * Constructor that pass an error message
     * @param message
     */
    public ApplicationError(String message)
    {
        super(message);
    }
    /**
     * Constructor that pass an error message and a throwable exception
     * @param message
     * @param exception
     */
    public ApplicationError(String message, Throwable exception)
    {
        super(message, exception);
    }
}
