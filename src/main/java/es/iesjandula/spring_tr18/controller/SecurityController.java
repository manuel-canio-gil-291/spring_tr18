package es.iesjandula.spring_tr18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController 
{
    @RequestMapping("/login")
    public String login()
    {
        return "secured/acceder";
    }
}
