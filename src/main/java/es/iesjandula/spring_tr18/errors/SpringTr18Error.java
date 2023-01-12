package es.iesjandula.spring_tr18.errors;

import java.util.HashMap;

public class SpringTr18Error extends Exception
{
    private static final long serialVersionUID = 1L;
    
    private Integer code;
    private String message;

    public SpringTr18Error(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public Object getSpringTr18ErrorMessage()
    {
        HashMap<String, Object> hashMapErrorMessage = new HashMap<>();

        hashMapErrorMessage.put("code", this.code);
        hashMapErrorMessage.put("message", this.message);

        return hashMapErrorMessage;
    }
}
