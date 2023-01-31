package es.iesjandula.spring_tr18.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.iesjandula.spring_tr18.errors.ApplicationError;
import es.iesjandula.spring_tr18.models.*;
import es.iesjandula.spring_tr18.repositories.*;
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

    @Autowired
    public IReservaAulaRepository reservaAulaRepository;

    @Autowired
    public IReservaCarritoPCsRepository reservaCarritoPCsRepository;

    @Autowired
    public IReservaCarritoTabletsRepository reservaCarritoTabletsRepository;

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
            return ResponseEntity.internalServerError().body(applicationError);
        }
    }

    @RequestMapping(value = "/profesores/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonProfesor(@PathVariable("id") Long id)
    {
        try 
        {
            String resultJson = "";
            Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new ApplicationError("No se encontro el id del profesor "+id));
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(profesor);

            return ResponseEntity.ok().body(resultJson);
        } 
        catch (ApplicationError applicationError) 
        {
            LOGGER.warn(applicationError);
            return ResponseEntity.badRequest().body(applicationError);
        }
        catch (Exception exception)
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_OBJECT_TO_JSON, exception);
            LOGGER.error(applicationError);
            return ResponseEntity.internalServerError().body(applicationError);
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

    @RequestMapping(value = "/aulas_informatica/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonAulaInformatica(@PathVariable("id") Long id)
    {
        try 
        {
            String resultJson = "";
            AulaInformatica aulaInformatica = aulaInformaticaRepository.findById(id).orElseThrow(() -> new ApplicationError("No se encontro el id de la aula de informatica "+id));
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(aulaInformatica);

            return ResponseEntity.ok().body(resultJson);
        } 
        catch (ApplicationError applicationError) 
        {
            LOGGER.warn(applicationError);
            return ResponseEntity.badRequest().body(applicationError);
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

    @RequestMapping(value = "/carritos_pcs/{id}")
    public ResponseEntity<?> getJsonCarritoPCs(@PathVariable("id") Long id)
    {
        try 
        {
            String resultJson = "";
            CarritoPCs carritoPCs = carritoPCsRepository.findById(id).orElseThrow(() -> new ApplicationError("No se encontro el id del carrito de ordenadores "+id));
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(carritoPCs);
            
            return ResponseEntity.ok().body(resultJson);
        } 
        catch (ApplicationError applicationError) 
        {
            LOGGER.warn(applicationError);
            return ResponseEntity.badRequest().body(applicationError);
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

    @RequestMapping(value = "/carritos_tablets/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonCarritoTablets(@PathVariable("id") Long id)
    {
        try 
        {
            String resultJson = "";
            CarritoTablets carritoTablets = carritoTabletsRepository.findById(id).orElseThrow(() -> new ApplicationError("No se encontro el id del carrito de tablets "+id));
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(carritoTablets);
            
            return ResponseEntity.ok().body(resultJson);
        } 
        catch (ApplicationError applicationError) 
        {
            LOGGER.warn(applicationError);
            return ResponseEntity.badRequest().body(applicationError);
        }
        catch (Exception exception)
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_OBJECT_TO_JSON, exception);
            LOGGER.error(applicationError);
            return ResponseEntity.internalServerError().body(applicationError);
        }
    }

    @RequestMapping(value = "/reservas_aulas", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonReservasAulasInformatica()
    {
        try 
        {
            String resultJson = "";
            List<ReservaAula> reservasAulas = reservaAulaRepository.findAll();
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(reservasAulas);

            return ResponseEntity.ok().body(resultJson);
        } 
        catch (Exception exception) 
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_OBJECT_TO_JSON, exception);
            LOGGER.error(applicationError);
            return ResponseEntity.internalServerError().body(applicationError);
        }
    }

    @RequestMapping(value = "/reservas_carritos_pcs", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonReservasCarritosPCs()
    {
        try 
        {
            String resultJson = "";
            List<ReservaCarritoPCs> reservasCarritosPCs = reservaCarritoPCsRepository.findAll();
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(reservasCarritosPCs);

            return ResponseEntity.ok().body(resultJson);
        } 
        catch (Exception exception) 
        {
            ApplicationError applicationError = new ApplicationError(Constants.E_PARSE_OBJECT_TO_JSON, exception);
            LOGGER.error(applicationError);
            return ResponseEntity.internalServerError().body(applicationError);
        }
    }

    @RequestMapping(value = "/reservas_carritos_tablets", method = RequestMethod.GET)
    public ResponseEntity<?> getJsonReservasCarritosTablets()
    {
        try 
        {
            String resultJson = "";
            List<ReservaCarritoTablets> reservasCarritosTablets = reservaCarritoTabletsRepository.findAll();
            JsonUtils jsonUtils = new JsonUtils();
            resultJson = jsonUtils.writeObjectToJsonAsPretty(reservasCarritosTablets);

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
