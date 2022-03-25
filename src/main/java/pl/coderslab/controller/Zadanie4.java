package pl.coderslab.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/first")
public class Zadanie4 {

    private static final Logger logger = LoggerFactory.getLogger(Zadanie4.class);

    @GetMapping("/form")
    public String hello() {
        return "form.jsp";
    }

    @PostMapping("/form")
    @ResponseBody
    public String metoda(@RequestParam("paramName") String paramName, @RequestParam("paramDate") String paramDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(paramDate, formatter);

        return paramName +" " + localDate;
    }
}
