package es.iesjandula.spring_tr18.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
/**
 * This class is an utility to set the configuration of the JSON
 * @author Manuel Canio Gil
 * @version 1.2.0
 */
public class Json 
{
    private static ObjectMapper MAPPER;
    
    public static ObjectMapper mapper()
    {
        if(Json.MAPPER == null)
        {
            Json.MAPPER = Json.createJson();
        }

        return Json.MAPPER;
    }
    /**
     * This method indicates the configuration to create the JSON
     * @return the mapper to create JSON
     */
    private static ObjectMapper createJson()
    {
        final ObjectMapper mapper = new ObjectMapper();

        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.FLUSH_AFTER_WRITE_VALUE, true);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        return mapper;
    }
}
