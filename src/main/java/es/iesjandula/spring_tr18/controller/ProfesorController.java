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
import es.iesjandula.spring_tr18.models.Profesor;
import es.iesjandula.spring_tr18.repositories.IProfesorRepository;
/**
 * This is a controller which you can add, modify or delete the teacher data
 * @author Manuel Canio Gil
 * @version 1.1.1
 */
@Controller
@RequestMapping(value = "/profesores")
public class ProfesorController 
{
    /**
     * Repository of the table "Teacher"
     */
    @Autowired
    public IProfesorRepository profesorRepository;
    /**
     * This URL is the main page of the table "Teacher"
     * @param model
     * @return the HTML main page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String paginaInicio(Model model)
    {
        model.addAttribute("lista_profesores", profesorRepository.findAll());

        return "profesores_inicio";
    }
    /**
     * This URL is a form which you can add new teacher's data
     * @param model
     * @return the HTML web page teacher's data form 
     */
    @RequestMapping(value = "/ver_formulario_nuevo_profesor", method = RequestMethod.GET)
    public String formularioNuevoProfesor(Model model)
    {
        Profesor profesor = new Profesor();

        model.addAttribute("profesor", profesor);

        return "nuevo_profesor";
    }
    /**
     * This URL add the new teacher's data in the table
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/guardar_profesor", method = RequestMethod.POST)
    public String guardarDatosProfesor(@ModelAttribute("profesor") Profesor profesor)
    {
        profesorRepository.save(profesor);

        return "redirect:/profesores/";
    }
    /**
     * This URL is a form which you can modify the teacher's data passing the id
     * @param model
     * @return the HTML web page teacher's data form
     * @throws ApplicationError
     */
    @RequestMapping(value = "/ver_formulario_actualizar_profesor/{id}", method = RequestMethod.GET)
    public String formularioActualizarProfesor(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new ApplicationError("El Id del profesor "+id+" no es valido"));

        model.addAttribute("profesor", profesor);

        return "actualizar_profesor";
    }
    /**
     * This URL modify the teacher's data in the table passing the id
     * @param model
     * @return redirection of the main page
     */
    @RequestMapping(value = "/actualizar_profesor/{id}", method = RequestMethod.POST)
    public String actualizarDatosProfesor(@PathVariable("id") Long id, Profesor profesor,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            profesor.setId(id);
            return "actualizar_profesor";
        }

        profesorRepository.save(profesor);

        return "redirect:/profesores/";
    }
    /**
     * This URL delete the teacher's data in the table
     * @param model
     * @return redirection of the main page
     * @throws ApplicationError
     */
    @RequestMapping(value = "/quitar_profesor/{id}", method = RequestMethod.GET)
    public String quitarProfesor(@PathVariable("id") Long id, Model model) throws ApplicationError
    {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new ApplicationError("El Id del profesor "+id+" no es valido"));

        profesorRepository.delete(profesor);

        return "redirect:/profesores/";
    }
}
