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

@Controller
public class CarritoTabletsController 
{
    @Autowired
    public ICarritoTabletsRepository carritoTabletsRepository;

    @GetMapping("/carritos_tablets")
    public String paginaInicio(Model model)
    {
        model.addAttribute("lista_carritos_tablets", carritoTabletsRepository.findAll());

        return "carritos_tablets_inicio";
    }

    @GetMapping("/carritos_tablets/ver_formulario_nuevo_carrito_tablets")
    public String formularioNuevoCarritoTablets(Model model)
    {
        CarritoTablets carritoTablets = new CarritoTablets();

        model.addAttribute("carrito_tablets", carritoTablets);

        return "nuevo_carrito_tablets";
    }

    @PostMapping("/carritos_tablets/guardar_carrito_tablets")
    public String guardarCarritoTablets(@ModelAttribute("carrito_tablets") CarritoTablets carritoTablets)
    {
        carritoTabletsRepository.save(carritoTablets);

        return "redirect:/carritos_tablets";
    }

    @GetMapping("/carritos_tablets/ver_formulario_actualizar_carrito_tablets/{id}")
    public String formularioActualizarCarritoTablets(@PathVariable("id") Long id, Model model)
    {
        CarritoTablets carritoTablets = carritoTabletsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el ID del carrito "+id));

        model.addAttribute("carrito_tablets", carritoTablets);

        return "actualizar_carrito_tablets";
    }

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

    @GetMapping("/carritos_tablets/quitar_carrito_tablets/{id}")
    public String quitarCarritoTablets(@PathVariable("id") Long id, Model model)
    {
        CarritoTablets carritoTablets = carritoTabletsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el ID del carrito "+id));

        carritoTabletsRepository.delete(carritoTablets);

        return "redirect:/carritos_tablets";
    }
}
