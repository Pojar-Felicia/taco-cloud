package tacos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/error"})
    public String home(){
        return "home";
    }
}                           //   *** should be deleted
