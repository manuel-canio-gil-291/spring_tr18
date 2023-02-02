package es.iesjandula.spring_tr18.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * This class is an utility to convert an object to JSON format
 * @author Manuel Canio Gil
 * @version 1.2.0
 */
public class JsonUtils 
{
    /**
     * Logger
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * This method allows transform an object into a JSON with the Pretty Format
     * @param objectToJson
     * @return the result in JSON format
     */
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
