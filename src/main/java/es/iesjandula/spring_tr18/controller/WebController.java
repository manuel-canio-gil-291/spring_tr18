/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.iesjandula.spring_tr18.errors.ApplicationError;
import es.iesjandula.spring_tr18.models.AulaInformatica;
import es.iesjandula.spring_tr18.models.CarritoPCs;
import es.iesjandula.spring_tr18.models.CarritoTablets;
import es.iesjandula.spring_tr18.models.ReservaAula;
import es.iesjandula.spring_tr18.models.ReservaCarritoPCs;
import es.iesjandula.spring_tr18.models.ReservaCarritoTablets;
import es.iesjandula.spring_tr18.repositories.IAulaInformaticaRepository;
import es.iesjandula.spring_tr18.repositories.ICarritoPCsRepository;
import es.iesjandula.spring_tr18.repositories.ICarritoTabletsRepository;
import es.iesjandula.spring_tr18.repositories.IReservaAulaRepository;
import es.iesjandula.spring_tr18.repositories.IReservaCarritoPCsRepository;
import es.iesjandula.spring_tr18.repositories.IReservaCarritoTabletsRepository;
/**
 * This is a controller which you can reserve a classroom, a tablet trolley and/or a PC trolley
 * @author Manuel Canio Gil
 * @version 1.2.0
 */
@Controller
@RequestMapping(value = "/reservas")
public class WebController 
{
    @Autowired
    public IAulaInformaticaRepository aulaInformaticaRepository;
    @Autowired
    public ICarritoPCsRepository carritoPCsRepository;
    @Autowired
    public ICarritoTabletsRepository carritoTabletsRepository;
    /**
     * Repository of the table "Reserve trolley tablet"
     */
    @Autowired
    public IReservaCarritoTabletsRepository reservaCarritoTabletsRepository;
    /**
     * Repository of the table "Reserve PC tablet"
     */
    @Autowired
    public IReservaCarritoPCsRepository reservaCarritoPCsRepository;
    /**
     * Repository of the table "Reserve trolley tablet"
     */
    @Autowired
    public IReservaAulaRepository reservaAulaRepository;
    /**
     * This URL is the main page of the reserves of the classrooms and trolleys
     * @param model
     * @return the HTML main page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String paginaInicioReservas(Model model)
    {
        model.addAttribute("lista_reservas_aulas", reservaAulaRepository.findAll());
        model.addAttribute("lista_reservas_carritos_pcs", reservaCarritoPCsRepository.findAll());
        model.addAttribute("lista_reservas_carritos_tablets", reservaCarritoTabletsRepository.findAll());

        return "reservas_inicio";
    }
    /**
     * This URL is a form which you can reserve a classroom that it exists in the database
     * @param model
     * @return the HTML web page of reserve classroom form 
     */
    @RequestMapping(value = "/formulario_nueva_reserva_aula", method = RequestMethod.GET)
    public String formularioNuevaReservaAula(Model model)
    {
        ReservaAula reservaAula = new ReservaAula();

        model.addAttribute("reserva_aula", reservaAula);

        return "nueva_reserva_aula";
    }
    /**
     * This URL is a form which you can reserve a PC trolley that it exists in the database 
     * @param model
     * @return the HTML web page of reserve PC trolley form 
     */
    @RequestMapping(value = "/formulario_nueva_reserva_carrito_pcs", method = RequestMethod.GET)
    public String formularioNuevaReservaCarritoPCs(Model model)
    {
        ReservaCarritoPCs reservaCarritoPCs = new ReservaCarritoPCs();

        model.addAttribute("reserva_carrito_pcs", reservaCarritoPCs);

        return "nueva_reserva_carrito_pcs";
    }
    /**
     * This URL is a form which you can reserve a tablet trolley that it exists in the database 
     * @param model
     * @return the HTML web page of reserve tablet trolley form 
     */
    @RequestMapping(value = "/formulario_nueva_reserva_carrito_tablets", method = RequestMethod.GET)
    public String formularioNuevaReservaCarritoTablets(Model model)
    {
        ReservaCarritoTablets reservaCarritoTablets = new ReservaCarritoTablets();

        model.addAttribute("reserva_carrito_tablets", reservaCarritoTablets);

        return "nueva_reserva_carrito_tablets";
    }
    /**
     * This URL save the reserve classroom in the database
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/guardar_reserva_aula", method = RequestMethod.POST)
    public String guardarReservaAula(@ModelAttribute("reserva_aula") ReservaAula reservaAula) throws ApplicationError
    {
        List<AulaInformatica> aulasInformatica = aulaInformaticaRepository.findAll();
        List<ReservaAula> reservasAula = reservaAulaRepository.findAll();
        if(reservasAula.size() != 0)
        {
            for(AulaInformatica aulaInformatica : aulasInformatica)
            {
                if(aulaInformatica.getId() == reservaAula.getIdAula().getId())
                {
                    for(ReservaAula reservaAulaIt : reservasAula)
                    {
                        if(reservaAula.getFecha().equals(reservaAulaIt.getFecha()))
                        {
                            throw new RuntimeException("No se puede guardar la reserva. La fecha "+reservaAula.getFecha()+" esta ocupada por otro profesor");
                        }
                    }
                }
            }
            reservaAulaRepository.save(reservaAula); 
        }
        else
        {
            reservaAulaRepository.save(reservaAula);
        }

        return "redirect:/reservas/";
    }
    /**
     * This URL save the reserve PC trolley in the database
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/guardar_reserva_carrito_pcs", method = RequestMethod.POST)
    public String guardarReservaCarritoPCs(@ModelAttribute("reserva_carrito_pcs") ReservaCarritoPCs reservaCarritoPCs)
    {
        List<CarritoPCs> carritosPCs = carritoPCsRepository.findAll();
        List<ReservaCarritoPCs> reservasCarritosPCs = reservaCarritoPCsRepository.findAll();
        if(reservasCarritosPCs.size() != 0)
        {
            for(CarritoPCs carritoPCs : carritosPCs)
            {
                if(carritoPCs.getId() == reservaCarritoPCs.getIdCarritoPcs().getId())
                {
                    for(ReservaCarritoPCs reservaCarritoPCsIt : reservasCarritosPCs)
                    {
                        if(reservaCarritoPCsIt.getDate().equals(reservaCarritoPCs.getDate()))
                        {
                            throw new RuntimeException("No se puede guardar la reserva. La fecha "+reservaCarritoPCs.getDate()+" esta ocupada por otro profesor");
                        }
                    }
                }
            }
            reservaCarritoPCsRepository.save(reservaCarritoPCs);
        }
        else
        {
            reservaCarritoPCsRepository.save(reservaCarritoPCs);
        }

        

        return "redirect:/reservas/";
    }
    /**
     * This URL save the reserve tablet trolley in the database
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/guardar_reserva_carrito_tablets", method = RequestMethod.POST)
    public String guardarReservaCarritoTablets(@ModelAttribute("reserva_carrito_tablets") ReservaCarritoTablets reservaCarritoTablets)
    {
        List<CarritoTablets> carritosTablets = carritoTabletsRepository.findAll();
        List<ReservaCarritoTablets> reservasCarritoTablets = reservaCarritoTabletsRepository.findAll();
        if(reservasCarritoTablets.size() != 0)
        {
            for(CarritoTablets carritoTablets : carritosTablets)
            {
                if(carritoTablets.getId() == reservaCarritoTablets.getIdCarritoTablets().getId())
                {
                    for(ReservaCarritoTablets reservaCarritoTabletsIt : reservasCarritoTablets)
                    {
                        if(reservaCarritoTabletsIt.getDate().equals(reservaCarritoTablets.getDate()))
                        {
                            throw new RuntimeException("No se puede guardar la reserva. La fecha "+reservaCarritoTablets.getDate()+" esta ocupada por otro profesor");
                        }
                    }
                }
            }
            reservaCarritoTabletsRepository.save(reservaCarritoTablets);
        }
        else
        {
            reservaCarritoTabletsRepository.save(reservaCarritoTablets);
        }


        return "redirect:/reservas/";
    }
    /**
     * This URL is a form which you can update the reserve classroom passing the date
     * @param model
     * @return the HTML web page of reserve classroom form with data
     * @throws ApplicationError
     */
    @RequestMapping(value = "/formulario_actualizar_reserva_aula/{id}", method = RequestMethod.GET)
    public String formularioActualizarReservaAula(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        ReservaAula reservaAula = reservaAulaRepository.findById(id).orElseThrow(() -> new ApplicationError("El id de la reserva del aula "+id+" no es valida"));

        model.addAttribute("reserva_aula", reservaAula);

        return "actualizar_reserva_aula";
    }
    /**
     * This URL is a form which you can update the reserve tablet trolley passing the id
     * @param model
     * @return the HTML web page of reserve tablet trolley form with data
     * @throws ApplicationError
     */
    @RequestMapping(value = "/formulario_actualizar_reserva_carrito_tablets/{id}", method = RequestMethod.GET)
    public String formularioActualizarReservaCarritoTablets(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        ReservaCarritoTablets reservaCarritoTablets = reservaCarritoTabletsRepository.findById(id).orElseThrow(() -> new ApplicationError("No se pudo encontrar la reserva del carrito de tablets numero "+id));

        model.addAttribute("reserva_carrito_tablets", reservaCarritoTablets);

        return "actualizar_reserva_carrito_tablets";
    }
    /**
     * This URL is a form which you can update the reserve classroom passing the id
     * @param model
     * @return the HTML web page of reserve classroom form with data
     * @throws ApplicationError
     */
    @RequestMapping(value = "/formulario_actualizar_reserva_carrito_pcs/{id}", method = RequestMethod.GET)
    public String formularioActualizarReservaCarritoPCs(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        ReservaCarritoPCs reservaCarritoPCs = reservaCarritoPCsRepository.findById(id).orElseThrow(() -> new ApplicationError("No se pudo encontrar la reserva del carrito de ordenadores numero "+id));

        model.addAttribute("reserva_carrito_pcs", reservaCarritoPCs);

        return "actualizar_reserva_carrito_pcs";
    }
    /**
     * This URL update the reserve classroom in the database passing the date
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/actualizar_reserva_aula/{id}", method = RequestMethod.POST)
    public String actualizarReservaAula(@PathVariable("id") Long id, ReservaAula reservaAula,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            reservaAula.setId(id);

            return "actualizar_reserva_carrito_pcs";
        }

        reservaAulaRepository.save(reservaAula);

        return "redirect:/reservas/";
    }
    /**
     * This URL update the reserve tablet trolley in the database passing the id
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/actualizar_reserva_carrito_tablets/{id}", method = RequestMethod.POST)
    public String actualizarReservaCarritoTablets(@PathVariable("id") Long id, ReservaCarritoTablets reservaCarritoTablets,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            reservaCarritoTablets.setId(id);

            return "actualizar_reserva_carrito_tablets";
        }

        reservaCarritoTabletsRepository.save(reservaCarritoTablets);

        return "redirect:/reservas/";
    }
    /**
     * This URL update the reserve PC trolley in the database passing the id
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/actualizar_reserva_carrito_pcs/{id}", method = RequestMethod.POST)
    public String actualizarReservaCarritoPCs(@PathVariable("id") Long id, ReservaCarritoPCs reservaCarritoPCs,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            reservaCarritoPCs.setId(id);

            return "actualizar_reserva_carrito_pcs";
        }

        reservaCarritoPCsRepository.save(reservaCarritoPCs);

        return "redirect:/reservas/";
    }
    /**
     * This URL delete the reserve classroom in the database passing the date
     * @param model
     * @return redirection of the main page
     * @throws ApplicationError
     */
    @RequestMapping(value = "/anular_reserva_aula/{id}", method = RequestMethod.GET)
    public String anularReservaAula(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        ReservaAula reservaAula = reservaAulaRepository.findById(id).orElseThrow(() -> new ApplicationError("El id de la reserva del aula "+id+" no es valida"));

        reservaAulaRepository.delete(reservaAula);

        return "redirect:/reservas/";
    }
    /**
     * This URL delete the reserve tablet trolley in the database passing the id
     * @param model
     * @return redirection of the main page
     * @throws ApplicationError
     */
    @RequestMapping(value = "/anular_reserva_carrito_tablets/{id}", method = RequestMethod.GET)
    public String anularReservaCarritoTablets(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        ReservaCarritoTablets reservaCarritoTablets = reservaCarritoTabletsRepository.findById(id).orElseThrow(() -> new ApplicationError("No se pudo encontrar la reserva del carrito de tablets numero "+id));

        reservaCarritoTabletsRepository.delete(reservaCarritoTablets);

        return "redirect:/reservas/";
    }
    /**
     * This URL delete the reserve PC trolley in the database passing the id
     * @param model
     * @return redirection of the main page
     * @throws ApplicationError
     */
    @RequestMapping(value = "/anular_reserva_carrito_pcs/{id}", method = RequestMethod.GET)
    public String anularReservaCarritoPCs(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        ReservaCarritoPCs reservaCarritoPCs = reservaCarritoPCsRepository.findById(id).orElseThrow(() -> new ApplicationError("No se pudo encontrar la reserva del carrito de ordenadores numero "+id));

        reservaCarritoPCsRepository.delete(reservaCarritoPCs);

        return "redirect:/reservas/";
    }
}
