
package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;


@Controller
@RequestMapping("/wyklad")
public class Wyklad {
    private static final Logger logger = LoggerFactory.getLogger(Wyklad.class);


    @GetMapping("/random/{max}")
    @ResponseBody
    public String getRandomMax(@PathVariable Integer max) {
        int random = new Random().nextInt(max) + 1;

        return String.format("Użytkownik podał wartość max %d. Wylosowano liczbę: %d.", max, random);
    }

    @GetMapping("/random/{max}/{min}")
    @ResponseBody
    public String getRandomMax(@PathVariable Integer max, @PathVariable Integer min) {
        int random = new Random().nextInt(max - min + 1) + min;

//        max = 10 min = 5, mozliwe wartosci 5,6,7,8,9,10;
//        jezeli nextInt(10) -> 0 - 9      +5 -> 5 do 14
//            10-5 -> 0 - 4   + 5 -> 5 do 9 Moze wam sie ta matematyka przyda, nie wiadomo

        return String.format("Użytkownik podał wartość min = %d i max = %d. Wylosowano liczbę: %d.", min, max, random);
    }


    @GetMapping("/test-servlet-request")
    @ResponseBody
    public String getParamFromServletRequest(HttpServletRequest request) {
        return request.getParameter("query");
    }

    @GetMapping("/test-request-param")
    @ResponseBody
    public String getParamFromRequestParam(@RequestParam("query2") String query2) {
        return query2;
    }

    @GetMapping("/test-request-param2")
    @ResponseBody
    public String getParamFromRequestParam2(@RequestParam String query3) {
        return query3;
    }

    @GetMapping("/test-request-param-with-default")
    @ResponseBody
    public String getParamFromRequestParamDefault(@RequestParam(defaultValue = "Nie podales nic do query4") String query4) {
        return query4;
    }

    @GetMapping("/test-request-param-with-required")
    @ResponseBody
    public String getParamFromRequestParamRequired(@RequestParam(required = true) String query5,
                                                   @RequestParam(required = false) String query6) {
        logger.info("Notuje wartosci parametru query");
        logger.info(query5);
        logger.info(query6);
        return "Sprawdz w konsoli czy cos sie wypisalo";
    }

    @GetMapping("/test-request-param-with-number")
    @ResponseBody
    public String getParamFromRequestParamNumber(@RequestParam Long number1,
                                                 @RequestParam Integer number2) {
        return String.valueOf(number1 + number2);
    }

    @GetMapping("/test/{number}/page")
    @ResponseBody
    public String getPathVariable(@PathVariable Long number) {
        return number.toString();
    }

    @GetMapping("/userAgn")
    @ResponseBody
    public String userAgent(@RequestHeader("user-agent") String userAgent) {
        return "user-agent = " + userAgent;
    }

    /**
     * Znane metody http
     * GET
     * POST
     * PUT
     * DELETE
     * etc.
     */

    @GetMapping("/logs")
    @ResponseBody
    public String getLogs() {
        logger.debug("To jest log debugowy");
        logger.info("To jest log info, dodamy tutaj parametry {} <- cooo? {} ", "parametr1", 159);
        return "Logs should be in console";
    }


    //    @RequestMapping(value = "/response-encoding", produces = "text/plain;charset=UTF-8")
    @GetMapping("/body")
    @ResponseBody
    public String getBody() {
        return "To jest bezpośrednia odpowiedź, nie będziemy szukać widoków";
    }


    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String getHello() {
        return "index.jsp";
    }

    @RequestMapping(value = "/bye", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public String getBye() {
        return "byebye.jsp";
    }

    @GetMapping("/hello/{firstName}/{lastName}")
    @ResponseBody
    public String getPathVariable(@PathVariable String firstName, @PathVariable String lastName) {
        return "Witaj " + firstName + " " + lastName;
    }
}
