package es.iesjandula.spring_tr18.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class WebRestController 
{
    public WebRestController() 
    {

    }

    @RequestMapping(method = RequestMethod.GET, value = "/userVisits")
    public ResponseEntity<Integer> handleRequest(HttpSession session)
    {
        // Get the value of the session key (int)
        Integer userVisits = (Integer) session.getAttribute("userVisits");

        // Chech if value is null to initialize it
        if(userVisits == null)
        {
            userVisits = 0;
        }

        // Increment the value
        userVisits++;

        // Get the previous value
        System.out.println("User visits: " + userVisits);

        // Store in this session the current value
        session.setAttribute("userVisits", userVisits);

        // Return the value
        return ResponseEntity.ok().body(userVisits);
    }
}
