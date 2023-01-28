package es.iesjandula.spring_tr18.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonUtils 
{
    private static final Logger LOGGER = LogManager.getLogger();

    public String writeObjectToJsonAsPretty(Object objectToJson)
    {
        String resultJsonAsString = "";
        
        try
        {
            resultJsonAsString = Json.mapper().writerWithDefaultPrettyPrinter().writeValueAsString(objectToJson);
        }
        catch (Exception exception)
        {
            LOGGER.error("No se puede parsear esos datos a un formato Json", exception);
        }

        return resultJsonAsString;
    }
}
