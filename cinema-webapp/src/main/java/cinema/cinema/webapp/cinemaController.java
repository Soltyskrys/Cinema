/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.cinema.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Krystian
 */
@Controller
public class cinemaController {
    
    @RequestMapping(value ="/*", method = RequestMethod.GET)
    public String printHello(ModelMap model){
        model.addAttribute("message","Helo Spring MVC2");
        return "index";
    }
    @RequestMapping(value ="/dwa", method = RequestMethod.GET)
    public String printHell(ModelMap model){
        model.addAttribute("message","dwa");
        return "index";
    }
    
}
