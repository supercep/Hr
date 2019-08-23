package ru.unic.hr.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.unic.hr.model.Item;
import ru.unic.hr.service.loader.VacancyLoader;
import ru.unic.hr.service.parser.VacancyParser;
import ru.unic.hr.utils.HttpRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BritikovMI on 21.08.2019.
 */
@Controller
public class CalculateVacancy {

    @RequestMapping("/search")
    public String vacancyController(Model model) {
        String text = "java";
        String area = null;
        String salaryFrom = "";
        String content = VacancyLoader.load(text, area, salaryFrom);
        VacancyParser parser = new VacancyParser();
        ru.unic.hr.model.Model vacancyModel = null;
        List<Item> items = new ArrayList<>();

        if (content != null && !content.isEmpty()) {
            vacancyModel = parser.parse(content);
            items = vacancyModel.getItems();
        }
        model.addAttribute("items", items);
        return "db";
    }
}
