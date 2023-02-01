package es.iesjandula.spring_tr18.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageController implements ErrorController
{
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
