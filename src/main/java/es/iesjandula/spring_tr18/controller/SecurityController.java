/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * This is a controller that manage the application security endpoints
 * @author Manuel Canio Gil
 * @version 1.4.0
 */
@Controller
public class SecurityController 
{
    /**
     * This URL redirect automatically the login page when try to access a page with 
     * role identification
     * @return The login web page
     */
    @RequestMapping("/login")
    public String login()
    {
        return "acceder";
    }
    /**
     * This URL redirect automatically again the login page when the password 
     * or the user are incorrect
     * @param model
     * @return The login web page
     */
    @RequestMapping("/login-error")
    public String loginError(Model model)
    {
        model.addAttribute("loginError", true);
        return "acceder";
    }
    /**
     * This URL denied the access when try to access a page without permissions
     * @return The unauthorized access page
     */
    @RequestMapping("/acceso-denegado")
    public String accesoDenegado()
    {
        return "acceso_denegado";
    }
}
