package ru.unic.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.unic.utils.HttpRequest;

import java.util.List;

/**
 * Created by BritikovMI on 15.08.2019.
 */
@Controller
public class RestServiceController {

    @GetMapping("/search/{params}")
    public String search(@PathVariable("params") String params)  {
        return HttpRequest.doGet("https://api.hh.ru/vacancies?text=" + params).toString();
    }

    @RequestMapping("/hello")
    public String factSchedullerController(Model model) {
        model.addAttribute("message", "Каждую секунду");
        /*Html page initialization*/
        return "hello";
    }
}
