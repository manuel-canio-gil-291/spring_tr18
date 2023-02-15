package es.iesjandula.spring_tr18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController 
{
    @RequestMapping("/login")
    public String login()
    {
        return "acceder";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model)
    {
        model.addAttribute("loginError", true);
        return "acceder";
    }

    @RequestMapping("/acceso-denegado")
    public String accesoDenegado()
    {
        return "acceso_denegado";
    }
}
