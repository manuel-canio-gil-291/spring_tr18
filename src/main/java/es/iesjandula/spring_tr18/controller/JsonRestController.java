package es.iesjandula.spring_tr18.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.spring_tr18.errors.ApplicationError;
import es.iesjandula.spring_tr18.models.Profesor;
import es.iesjandula.spring_tr18.repositories.IProfesorRepository;
import es.iesjandula.spring_tr18.utils.Constants;
import es.iesjandula.spring_tr18.utils.JsonUtils;

@RestController
@RequestMapping(value = "/json_code", produces = {"application/json"})
public class JsonRestController 
{
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    public IProfesorRepository profesorRepository;

    @RequestMapping(value = "/profesores", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonProfesores()
    {
        try 
        {
            String resultJson = "";
            List<Profesor> profesores = profesorRepository.findAll();
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(profesores);

            return ResponseEntity.ok().body(resultJson);
        } 
        catch (Exception exception) 
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_OBJECT_TO_JSON, exception);
            LOGGER.error(applicationError);
            return ResponseEntity.status(500).body(applicationError);
        }
    }
}
