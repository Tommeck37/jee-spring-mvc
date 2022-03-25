package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;
@Controller
public class Widoki {


        private static final Logger logger = LoggerFactory.getLogger(Widoki.class);

        @GetMapping("/helloView")
        public String helloView(Model model){
            int hour = LocalTime.now().getHour(); //POBIERZ AKTUALNĄ GODZINĘ
            hour = 14;   //do testów zeby sprawdzić czy się przechodzi w tryb nocny
            if( hour > 8 && hour < 20) {
                model.addAttribute("color", "black");
                model.addAttribute("backgroundColor", "white");
            } else {
                model.addAttribute("color", "white");
                model.addAttribute("backgroundColor", "black");
            }

            return "index";
        }

    @GetMapping("/redirect")
    public String redirect(){
        return "redirect:redirect-outcome";
    }

    @GetMapping("/redirectredirect")
    public String redirectRedirect(){
        return "redirect:redirect:"; //404
    }

    @PostMapping("/redirect-outcome")
    @ResponseBody
    public String redirectOutcome(){
        return "zostalem przekierowany";
    }

    @GetMapping("/forward")
    public String forward(){
        return "forward:forward-outcome";
    }

    @GetMapping("/forwardforward")
    public String forwardforward(){
        return "forward:forward:"; //404
    }

    @PostMapping("/forward-outcome")
    @ResponseBody
    public String forwardOutcome(){
        return "zostalem przeforwardowany";
    }
}
