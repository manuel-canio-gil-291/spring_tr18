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

@Controller
public class ProfesorController 
{
    @Autowired
    public IProfesorRepository profesorRepository;

    @GetMapping("/profesores")
    public String paginaInicio(Model model)
    {
        model.addAttribute("lista_profesores", profesorRepository.findAll());

        return "profesores_inicio";
    }

    @GetMapping("/profesores/ver_formulario_nuevo_profesor")
    public String formularioNuevoProfesor(Model model)
    {
        Profesor profesor = new Profesor();

        model.addAttribute("profesor", profesor);

        return "nuevo_profesor";
    }

    @PostMapping("/profesores/guardar_profesor")
    public String guardarDatosProfesor(@ModelAttribute("profesor") Profesor profesor)
    {
        profesorRepository.save(profesor);

        return "redirect:/profesores";
    }

    @GetMapping("profesores/ver_formulario_actualizar_profesor/{id}")
    public String formularioActualizarProfesor(@PathVariable("id") Long id, Model model)
    {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El Id del profesor "+id+" no es valido"));

        model.addAttribute("profesor", profesor);

        return "actualizar_profesor";
    }

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

    @GetMapping("profesores/quitar_profesor/{id}")
    public String quitarProfesor(@PathVariable("id") Long id, Model model)
    {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El Id del profesor "+id+" no es valido"));

        profesorRepository.delete(profesor);

        return "redirect:/profesores";
    }
}
