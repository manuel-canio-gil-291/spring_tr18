package es.iesjandula.spring_tr18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.iesjandula.spring_tr18.models.Profesor;

@Controller
public class WebController 
{
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(Model model)
    {
        model.addAttribute("teacher", new Profesor());
        return "identificacion.html";
    }  
}
