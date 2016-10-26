package cinema.cinema.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krystian
 */
@Controller
@RequestMapping(value ="/")
public class HomeController {
    
    @RequestMapping(value ="")
    public String homePage(ModelMap model){
        return "index";
    }
}
