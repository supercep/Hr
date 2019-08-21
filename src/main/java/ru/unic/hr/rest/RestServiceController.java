package ru.unic.hr.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.unic.hr.model.Model;
import ru.unic.hr.service.parser.VacancyParser;
import ru.unic.hr.utils.*;

/**
 * Created by BritikovMI on 15.08.2019.
 */
@Controller
public class RestServiceController {

    @GetMapping("/search/{params}")
    public Model search(@PathVariable("params") String params)  {
        VacancyParser parser = new VacancyParser();
        Model model = parser.parse(HttpRequest.doGet("https://api.hh.ru/vacancies?text=" + params).toString());

        return model;
    }

    @RequestMapping("/hello")
    public String factSchedullerController(Model model) {
//        model.addAttribute("message", "Каждую секунду");
        /*Html page initialization*/
        return "hello";
    }
}
