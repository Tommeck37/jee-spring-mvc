package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Controller
@ResponseBody
public class FreeTimeController {
    private static final Logger logger = LoggerFactory.getLogger(FreeTimeController.class);

    LocalDateTime date = LocalDateTime.now();
    Integer hourTimes = LocalDateTime.now().getHour();
    DayOfWeek dayTimes = date.getDayOfWeek();

    @GetMapping("/FreeTime")
    @ResponseBody
    public String freeTime() {
        if (dayTimes.equals(DayOfWeek.SUNDAY) | dayTimes.equals(DayOfWeek.SATURDAY)) {
            return "Wolne";
        } else if (hourTimes > 9| hourTimes < 17){
            return "Pracuje nie dzwoń";
        }
        return "Po pracy";

    }
}