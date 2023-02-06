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
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * This is a controller that shows the index page
 * @author Manuel Canio Gil
 * @version 1.3.1
 */
@Controller
@RequestMapping(value = "/inicio")
public class IndexController 
{
    /**
     * This URL shows the main page
     * @param model
     * @return the main HTML web page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model)
    {
        return "inicio";
    }
    /**
     * This URL is the about this app page
     * @param model
     * @return the HTML web page about app
     */
    @RequestMapping(value = "/acerca_de", method = RequestMethod.GET)
    public String aboutApp(Model model)
    {
        return "acerca_de";
    }
}
