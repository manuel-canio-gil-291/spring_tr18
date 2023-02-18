/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
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
/**
 * This is a rest controller which it shows data of the database in JSON code
 * @author Manuel Canio Gil
 * @version 1.4.0
 */
@RestController
@RequestMapping(value = "/json_code", produces = {"application/json"})
public class JsonRestController 
{
    /**
     * Logger
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * Repository of the table "Teacher"
     */
    @Autowired
    public IProfesorRepository profesorRepository;
    /**
     * Repository of the table "TIC classroom"
     */
    @Autowired
    public IAulaInformaticaRepository aulaInformaticaRepository;
    /**
     * Repository of the table "PC trolley"
     */
    @Autowired
    public ICarritoPCsRepository carritoPCsRepository;
    /**
     * Repository of the table "Tablet trolley"
     */
    @Autowired
    public ICarritoTabletsRepository carritoTabletsRepository;
    /**
     * Repository of the table "Classroom reservations"
     */
    @Autowired
    public IReservaAulaRepository reservaAulaRepository;
    /**
     * Repository of the table "PC trolley reservations"
     */
    @Autowired
    public IReservaCarritoPCsRepository reservaCarritoPCsRepository;
    /**
     * Repository of the table "Tablet trolley reservations"
     */
    @Autowired
    public IReservaCarritoTabletsRepository reservaCarritoTabletsRepository;
    /**
     * This endpoint return all teachers data
     * @return Teachers data in JSON code
     */
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
    /**
     * This endpoint return the teacher data passing the id
     * @param id
     * @return Teacher data in JSON code
     */
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
    /**
     * This endpoint return all TIC classrooms data
     * @return TIC classrooms data in JSON code
     */
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
    /**
     * This endpoint return the TIC classroom data passing the id
     * @param id
     * @return TIC classroom data in JSON code
     */
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
    /**
     * This endpoint return all PC trolleys data
     * @return PC trolleys data in JSON code
     */
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
    /**
     * This endpoint return the PC trolley data passing the id
     * @param id
     * @return PC trolley data in JSON code
     */
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
    /**
     * This endpoint returns all tablet trolleys data
     * @return Tablet trolleys data in JSON code
     */
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
    /**
     * This endpoint return the tablet trolley data passing the id
     * @param id
     * @return Tablet trolley data in JSON code
     */
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
    /**
     * This endpoint return all TIC classroom reservations
     * @return Classroom reservations in JSON code
     */
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
    /**
     * This endpoint return all PC trolleys reservations
     * @return PC trolleys reservations in JSON code
     */
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
    /**
     * This endpoint return all tablet trolleys reservations
     * @return Tablet trolleys reservations in JSON code
     */
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
