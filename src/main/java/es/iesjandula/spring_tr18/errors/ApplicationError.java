package es.iesjandula.spring_tr18.errors;

public class ApplicationError extends Exception 
{
    public ApplicationError()
    {
        super();
    }
    
    public ApplicationError(String message)
    {
        super(message);
    }

    public ApplicationError(String message, Throwable exception)
    {
        super(message, exception);
    }
}
