/**
 * ------------------------------------------------------
 * | WARNING!!!                                         |
 * | This is a stable version of the code application.  |
 * | Please, don't modify!                              |
 * ------------------------------------------------------
 */
package es.iesjandula.spring_tr18.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
/**
 * This is a controller which shows the error page that replaces the Whitelabel Error Page
 * @author Manuel Canio Gil
 * @version 1.3.0
 */
@Controller
public class ErrorPageController implements ErrorController
{
    /**
     * This endpoint shows the error page and the status code returned by the server
     * @param request
     * @param model
     * @return Error HTML web page
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) 
    {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null)
        {
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value())
            {
                model.addAttribute("error_code", statusCode);
                return "pagina_error_usuario";
            }
            else if(statusCode == HttpStatus.BAD_REQUEST.value())
            {
                model.addAttribute("error_code", statusCode);
                return "pagina_error_usuario";
            }
            else if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value())
            {
                model.addAttribute("error_code", statusCode);
                return "pagina_error_usuario";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value())
            {
                model.addAttribute("error_code", statusCode);
                return "pagina_error_servidor";
            }
            else
            {
                model.addAttribute("error_code", statusCode);
                return "pagina_error_otro";
            }
        }
        return "pagina_error_unknown";

    }
}
