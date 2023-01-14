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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.iesjandula.spring_tr18.models.CarritoTablets;
import es.iesjandula.spring_tr18.repositories.ICarritoTabletsRepository;
/**
 * This is a controller which you can add, modify or delete the tablet trolley in the table
 * @author Manuel Canio Gil
 * @version 1.0.0
 */
@Controller
public class CarritoTabletsController 
{
    /**
     * Repository of the table "Tablet trolley"
     */
    @Autowired
    public ICarritoTabletsRepository carritoTabletsRepository;
    /**
     * This URL is the main page of the table "Tablet trolley"
     * @param model
     * @return the HTML main page
     */
    @GetMapping("/carritos_tablets")
    public String paginaInicio(Model model)
    {
        model.addAttribute("lista_carritos_tablets", carritoTabletsRepository.findAll());

        return "carritos_tablets_inicio";
    }
    /**
     * This URL is a form which you can add new tablet trolley data
     * @param model
     * @return the HTML web page tablet trolley data form 
     */
    @GetMapping("/carritos_tablets/ver_formulario_nuevo_carrito_tablets")
    public String formularioNuevoCarritoTablets(Model model)
    {
        CarritoTablets carritoTablets = new CarritoTablets();

        model.addAttribute("carrito_tablets", carritoTablets);

        return "nuevo_carrito_tablets";
    }
    /**
     * This URL add the new tablet trolley data in the table
     * @param model
     * @return redirection of the main page
     */
    @PostMapping("/carritos_tablets/guardar_carrito_tablets")
    public String guardarCarritoTablets(@ModelAttribute("carrito_tablets") CarritoTablets carritoTablets)
    {
        carritoTabletsRepository.save(carritoTablets);

        return "redirect:/carritos_tablets";
    }
    /**
     * This URL is a form which you can update the tablet trolley data passing the id
     * @param model
     * @return the HTML web page tablet trolley data form 
     */
    @GetMapping("/carritos_tablets/ver_formulario_actualizar_carrito_tablets/{id}")
    public String formularioActualizarCarritoTablets(@PathVariable("id") Long id, Model model)
    {
        CarritoTablets carritoTablets = carritoTabletsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el ID del carrito "+id));

        model.addAttribute("carrito_tablets", carritoTablets);

        return "actualizar_carrito_tablets";
    }
    /**
     * This URL update the tablet trolley data in the table passing the id
     * @param model
     * @return redirection of the main page
     */
    @PostMapping("/carritos_tablets/actualizar_carrito_tablets/{id}")
    public String actualizarDatosCarritoTablets(@PathVariable("id") Long id, CarritoTablets carritoTablets,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            carritoTablets.setId(id);

            return "actualizar_carrito_tablets";
        }

        carritoTabletsRepository.save(carritoTablets);

        return "redirect:/carritos_tablets";
    }
    /**
     * This URL delete the tablet trolley data in the table
     * @param model
     * @return redirection of the main page
     */
    @GetMapping("/carritos_tablets/quitar_carrito_tablets/{id}")
    public String quitarCarritoTablets(@PathVariable("id") Long id, Model model)
    {
        CarritoTablets carritoTablets = carritoTabletsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el ID del carrito "+id));

        carritoTabletsRepository.delete(carritoTablets);

        return "redirect:/carritos_tablets";
    }
}
