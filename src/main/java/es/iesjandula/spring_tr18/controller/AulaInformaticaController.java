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

import es.iesjandula.spring_tr18.models.AulaInformatica;
import es.iesjandula.spring_tr18.repositories.IAulaInformaticaRepository;
/**
 * This is a controller which you can add, modify or delete the classroom in the table
 * @author Manuel Canio Gil
 * @version 1.1.1
 */
@Controller
@RequestMapping(value = "/aulas_informatica")
public class AulaInformaticaController 
{
    /**
     * Repository of the table "TIC classroom"
     */
    @Autowired
    public IAulaInformaticaRepository aulaInformaticaRepository;
    /**
     * This URL is the main page of the table "TIC classroom"
     * @param model
     * @return the HTML main page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String paginaInicio(Model model)
    {
        model.addAttribute("lista_aulas", aulaInformaticaRepository.findAll());

        return "aulas_informatica_inicio";
    }
    /**
     * This URL is a form which you can add new classroom data
     * @param model
     * @return the HTML web page classroom data form 
     */
    @RequestMapping(value = "/ver_formulario_nueva_aula", method = RequestMethod.GET)
    public String formularioNuevaAula(Model model)
    {
        AulaInformatica aulaInformatica = new AulaInformatica();

        model.addAttribute("aula_informatica", aulaInformatica);

        return "nueva_aula";
    }
    /**
     * This URL add the new classroom data in the table
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/guardar_aula", method = RequestMethod.POST)
    public String guardarDatosAulaInformatica(@ModelAttribute("aula_informatica") AulaInformatica aulaInformatica)
    {
        aulaInformaticaRepository.save(aulaInformatica);

        return "redirect:/aulas_informatica/";
    }
    /**
     * This URL is a form which you can update the classroom data passing the id
     * @param model
     * @return the HTML web page classroom data form 
     */
    @RequestMapping(value = "/ver_formulario_actualizar_aula/{id}", method = RequestMethod.GET)
    public String formularioActualizarAula(@PathVariable("id") Long id, Model model)
    {
        AulaInformatica aulaInformatica = aulaInformaticaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de aula de informatica "+id+" no valido"));

        model.addAttribute("aula_informatica", aulaInformatica);

        return "actualizar_aula";
    }
    /**
     * This URL update the classroom data in the table passing the id
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/actualizar_aula/{id}", method = RequestMethod.POST)
    public String actualizarDatosAulaInformatica(@PathVariable("id") Long id, AulaInformatica aulaInformatica,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            aulaInformatica.setId(id);
            return "actualizar_aula";
        }

        aulaInformaticaRepository.save(aulaInformatica);

        return "redirect:/aulas_informatica/";
    }
    /**
     * This URL delete the classroom data in the table passing the id
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/quitar_aula/{id}", method = RequestMethod.GET)
    public String quitarAula(@PathVariable("id") Long id, Model model)
    {
        AulaInformatica aulaInformatica = aulaInformaticaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de aula de informatica "+id+" no valido"));

        aulaInformaticaRepository.delete(aulaInformatica);

        return "redirect:/aulas_informatica/";
    }
}
