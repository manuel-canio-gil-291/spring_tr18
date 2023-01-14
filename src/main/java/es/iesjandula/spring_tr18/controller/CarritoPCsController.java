package es.iesjandula.spring_tr18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.iesjandula.spring_tr18.models.CarritoPCs;
import es.iesjandula.spring_tr18.repositories.ICarritoPCsRepository;

@Controller
public class CarritoPCsController 
{
    @Autowired
    public ICarritoPCsRepository carritoPCsRepository;

    @GetMapping("/carritos_pcs")
    public String paginaInicio(Model model)
    {
        model.addAttribute("lista_carritos_pcs", carritoPCsRepository.findAll());

        return "carritos_pcs_inicio";
    }

    @GetMapping("/carritos_pcs/ver_formulario_nuevo_carrito_pcs")
    public String formularioNuevoCarritoPCs(Model model)
    {
        CarritoPCs carritoPCs = new CarritoPCs();

        model.addAttribute("carrito_pcs", carritoPCs);

        return "nuevo_carrito_pcs";
    }

    @PostMapping("/carritos_pcs/guardar_carrito_pcs")
    public String guardarDatosCarritoPCs(@ModelAttribute("carrito_pcs") CarritoPCs carritoPCs)
    {
        carritoPCsRepository.save(carritoPCs);

        return "redirect:/carritos_pcs";
    }

    @GetMapping("/carritos_pcs/ver_formulario_actualizar_carrito_pcs/{id}")
    public String formularioActualizarCarritoPCs(@PathVariable("id") Long id, Model model)
    {
        CarritoPCs carritoPCs = carritoPCsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el ID del carrito "+id));

        model.addAttribute("carrito_pcs", carritoPCs);

        return "actualizar_carrito_pcs";
    }

    @PostMapping("/carritos_pcs/actualizar_carrito_pcs/{id}")
    public String actualizarDatosCarritoPCs(@PathVariable("id") Long id, CarritoPCs carritoPCs,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            carritoPCs.setId(id);
            return "actualizar_carrito_pcs";
        }

        carritoPCsRepository.save(carritoPCs);

        return "redirect:/carritos_pcs";
    }

    @GetMapping("/carritos_pcs/quitar_carrito_pcs/{id}")
    public String quitarCarritoPCs(@PathVariable("id") Long id, Model model)
    {
        CarritoPCs carritoPCs = carritoPCsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el ID del carrito "+id));

        carritoPCsRepository.delete(carritoPCs);

        return "redirect:/carritos_pcs";
    }
}
