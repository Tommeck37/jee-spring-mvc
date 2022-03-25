package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MultiplyController {

    @GetMapping("/multiply")
    public String multiply(Model model,@RequestParam(defaultValue ="10" )String size){
    Integer liczba = Integer.parseInt(size);
    model.addAttribute("looper", liczba);
    return "multiply";

    }
    @GetMapping("/hello/{rows}/{col}")

    public String getPathVariable(Model model,@PathVariable String rows, @PathVariable String col) {
    Integer row = Integer.parseInt(rows);
    Integer cols = Integer.parseInt(col);
    model.addAttribute("row", row);
    model.addAttribute("col", cols);
    return "widok";
    }
}
