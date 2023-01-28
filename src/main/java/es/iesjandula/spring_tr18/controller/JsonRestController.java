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
import es.iesjandula.spring_tr18.models.AulaInformatica;
import es.iesjandula.spring_tr18.models.CarritoPCs;
import es.iesjandula.spring_tr18.models.CarritoTablets;
import es.iesjandula.spring_tr18.models.Profesor;
import es.iesjandula.spring_tr18.repositories.IAulaInformaticaRepository;
import es.iesjandula.spring_tr18.repositories.ICarritoPCsRepository;
import es.iesjandula.spring_tr18.repositories.ICarritoTabletsRepository;
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

    @Autowired
    public IAulaInformaticaRepository aulaInformaticaRepository;

    @Autowired
    public ICarritoPCsRepository carritoPCsRepository;

    @Autowired
    public ICarritoTabletsRepository carritoTabletsRepository;

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
            return ResponseEntity.internalServerError() .body(applicationError);
        }
    }

    @RequestMapping(value = "/aulas_informatica", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonAulasInformatica()
    {
        try 
        {
            String resultJson = "";
            List<AulaInformatica> aulasInformatica = aulaInformaticaRepository.findAll();
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(aulasInformatica);

            return ResponseEntity.ok().body(resultJson);
        } 
        catch (Exception exception) 
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_OBJECT_TO_JSON, exception);
            LOGGER.error(applicationError);
            return ResponseEntity.internalServerError().body(applicationError);
        }
    }

    @RequestMapping(value = "/carritos_pcs", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonCarritosPCs()
    {
        try 
        {
            String resultJson = "";
            List<CarritoPCs> carritosPCs = carritoPCsRepository.findAll();
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(carritosPCs);

            return ResponseEntity.ok().body(resultJson);
        } 
        catch (Exception exception) 
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_OBJECT_TO_JSON, exception);
            LOGGER.error(applicationError);
            return ResponseEntity.internalServerError().body(applicationError);
        }
    }

    @RequestMapping(value = "/carritos_tablets", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonCarritosTablets()
    {
        try 
        {
            String resultJson = "";
            List<CarritoTablets> carritosTablets = carritoTabletsRepository.findAll();
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(carritosTablets);

            return ResponseEntity.ok().body(resultJson);
        } 
        catch (Exception exception) 
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_OBJECT_TO_JSON, exception);
            LOGGER.error(applicationError);
            return ResponseEntity.internalServerError().body(applicationError);
        }
    }
}
