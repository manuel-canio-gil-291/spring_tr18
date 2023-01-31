package es.iesjandula.spring_tr18.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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
