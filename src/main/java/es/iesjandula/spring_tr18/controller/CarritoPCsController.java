/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.iesjandula.spring_tr18.errors.ApplicationError;
import es.iesjandula.spring_tr18.models.CarritoPCs;
import es.iesjandula.spring_tr18.repositories.ICarritoPCsRepository;
/**
 * This is a controller which you can add, modify or delete the PC trolley in the table
 * @author Manuel Canio Gil
 * @version 1.2.0
 */
@Controller
@RequestMapping(value = "/carritos_pcs")
public class CarritoPCsController 
{
    /**
     * Repository of the table "PC trolley"
     */
    @Autowired
    public ICarritoPCsRepository carritoPCsRepository;
    /**
     * This URL is the main page of the table "PC trolley"
     * @param model
     * @return the HTML main page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String paginaInicio(Model model)
    {
        model.addAttribute("lista_carritos_pcs", carritoPCsRepository.findAll());

        return "carritos_pcs_inicio";
    }
    /**
     * This URL is a form which you can add new PC trolley data
     * @param model
     * @return the HTML web page PC trolley data form 
     */
    @RequestMapping(value = "/ver_formulario_nuevo_carrito_pcs", method = RequestMethod.GET)
    public String formularioNuevoCarritoPCs(Model model)
    {
        CarritoPCs carritoPCs = new CarritoPCs();

        model.addAttribute("carrito_pcs", carritoPCs);

        return "nuevo_carrito_pcs";
    }
    /**
     * This URL add the new PC trolley data in the table
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/guardar_carrito_pcs", method = RequestMethod.POST)
    public String guardarDatosCarritoPCs(@ModelAttribute("carrito_pcs") CarritoPCs carritoPCs)
    {
        carritoPCsRepository.save(carritoPCs);

        return "redirect:/carritos_pcs/";
    }
    /**
     * This URL is a form which you can update the PC trolley data passing the id
     * @param model
     * @return the HTML web page PC trolley data form 
     * @throws ApplicationError
     */
    @RequestMapping(value = "/ver_formulario_actualizar_carrito_pcs/{id}", method = RequestMethod.GET)
    public String formularioActualizarCarritoPCs(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        CarritoPCs carritoPCs = carritoPCsRepository.findById(id).orElseThrow(() -> new ApplicationError("No se ha encontrado el ID del carrito "+id));

        model.addAttribute("carrito_pcs", carritoPCs);

        return "actualizar_carrito_pcs";
    }
    /**
     * This URL update the PC trolley data in the table passing the id
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/actualizar_carrito_pcs/{id}", method = RequestMethod.POST)
    public String actualizarDatosCarritoPCs(@PathVariable("id") Long id, CarritoPCs carritoPCs,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            carritoPCs.setId(id);
            return "actualizar_carrito_pcs";
        }

        carritoPCsRepository.save(carritoPCs);

        return "redirect:/carritos_pcs/";
    }
    /**
     * This URL delete the PC trolley data in the table
     * @param model
     * @return redirection of the main page
     * @throws ApplicationError
     */
    @RequestMapping(value = "/quitar_carrito_pcs/{id}", method = RequestMethod.GET)
    public String quitarCarritoPCs(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        CarritoPCs carritoPCs = carritoPCsRepository.findById(id).orElseThrow(() -> new ApplicationError("No se ha encontrado el ID del carrito "+id));

        carritoPCsRepository.delete(carritoPCs);

        return "redirect:/carritos_pcs/";
    }
}
