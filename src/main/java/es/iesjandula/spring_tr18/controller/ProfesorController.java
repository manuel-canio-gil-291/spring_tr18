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

import es.iesjandula.spring_tr18.models.Profesor;
import es.iesjandula.spring_tr18.repositories.IProfesorRepository;
/**
 * This is a controller which you can add, modify or delete the teacher data
 * @author Manuel Canio Gil
 * @version 1.0.0
 */
@Controller
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
    @GetMapping("/profesores")
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
    @GetMapping("/profesores/ver_formulario_nuevo_profesor")
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
    @PostMapping("/profesores/guardar_profesor")
    public String guardarDatosProfesor(@ModelAttribute("profesor") Profesor profesor)
    {
        profesorRepository.save(profesor);

        return "redirect:/profesores";
    }
    /**
     * This URL is a form which you can modify the teacher's data passing the id
     * @param model
     * @return the HTML web page teacher's data form
     */
    @GetMapping("profesores/ver_formulario_actualizar_profesor/{id}")
    public String formularioActualizarProfesor(@PathVariable("id") Long id, Model model)
    {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El Id del profesor "+id+" no es valido"));

        model.addAttribute("profesor", profesor);

        return "actualizar_profesor";
    }
    /**
     * This URL modify the teacher's data in the table passing the id
     * @param model
     * @return redirection of the main page
     */
    @PostMapping("profesores/actualizar_profesor/{id}")
    public String actualizarDatosProfesor(@PathVariable("id") Long id, Profesor profesor,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            profesor.setId(id);
            return "actualizar_profesor";
        }

        profesorRepository.save(profesor);

        return "redirect:/profesores";
    }
    /**
     * This URL delete the teacher's data in the table
     * @param model
     * @return redirection of the main page
     */
    @GetMapping("profesores/quitar_profesor/{id}")
    public String quitarProfesor(@PathVariable("id") Long id, Model model)
    {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El Id del profesor "+id+" no es valido"));

        profesorRepository.delete(profesor);

        return "redirect:/profesores";
    }
}
