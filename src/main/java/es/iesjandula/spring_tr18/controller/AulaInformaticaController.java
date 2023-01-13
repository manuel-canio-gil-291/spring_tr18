package es.iesjandula.spring_tr18.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.iesjandula.spring_tr18.models.AulaInformatica;
import es.iesjandula.spring_tr18.repositories.IAulaInformaticaRepository;

@Controller
public class AulaInformaticaController 
{
    @Autowired
    public IAulaInformaticaRepository aulaInformaticaRepository;

    @GetMapping("/aulas_informatica")
    public String paginaInicio(Model model)
    {
        model.addAttribute("lista_aulas", aulaInformaticaRepository.findAll());

        return "aulas_informatica_inicio";
    }

    @GetMapping("/aulas_informatica/ver_formulario_nueva_aula")
    public String formularioNuevaAula(Model model)
    {
        AulaInformatica aulaInformatica = new AulaInformatica();

        model.addAttribute("aula_informatica", aulaInformatica);

        return "nueva_aula";
    }

    @PostMapping("/aulas_informatica/guardar_aula")
    public String guardarDatosAulaInformatica(@ModelAttribute("aula_informatica") AulaInformatica aulaInformatica)
    {
        aulaInformaticaRepository.save(aulaInformatica);

        return "redirect:/aulas_informatica_inicio";
    }

    @GetMapping("/aulas_informatica/ver_formulario_actualizar_aula/{id}")
    public String formularioActualizarAula(@PathVariable("id") Long id, Model model)
    {
        AulaInformatica aulaInformatica = aulaInformaticaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de aula de informatica "+id+" no valido"));

        model.addAttribute("aula_informatica", aulaInformatica);

        return "actualizar_aula";
    }

    @PostMapping("/aulas_informatica/actualizar_aula/{id}")
    public String actualizarDatosAulaInformatica(@PathVariable("id") Long id, AulaInformatica aulaInformatica,
    BindingResult result, Model model)
    {
        if(result.hasErrors())
        {
            aulaInformatica.setId(id);
            return "actualizar_aula";
        }

        aulaInformaticaRepository.save(aulaInformatica);

        return "redirect:/aulas_informatica_inicio";
    }

    @GetMapping("/aulas_informatica/quitar_aula/{id}")
    public String quitarAula(@PathVariable("id") Long id, Model model)
    {
        AulaInformatica aulaInformatica = aulaInformaticaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID de aula de informatica "+id+" no valido"));

        aulaInformaticaRepository.delete(aulaInformatica);
        
        return "redirect:/aulas_informatica_inicio";
    }
}
