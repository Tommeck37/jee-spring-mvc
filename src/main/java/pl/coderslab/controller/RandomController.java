package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@ResponseBody
public class RandomController {
    private static final Logger logger = LoggerFactory.getLogger(RandomController.class);
    Random random = new Random();

    @GetMapping("/show-random")
    @ResponseBody
    public String showRandom(){
        Integer r = random.nextInt(100)+1;
        return "Wylosowano numer " + r;
    }
}
