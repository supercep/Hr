package ru.unic.hr.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.unic.hr.model.form.Experience;
import ru.unic.hr.model.form.Form;
import ru.unic.hr.model.Item;

import ru.unic.hr.service.DataAnalysis;
import ru.unic.hr.service.parser.VacancyParser;
import ru.unic.hr.utils.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ru.unic.hr.model.form.Experience.getExperiences;
import static ru.unic.hr.service.CalculateVacancy.getVacancies;

/**
 * Created by BritikovMI on 15.08.2019.
 */
@Controller
public class RestServiceController {

    @RequestMapping("/search/{params}")
    public ru.unic.hr.model.Model search(@PathVariable("params") String params) {
        VacancyParser parser = new VacancyParser();
        ru.unic.hr.model.Model model = parser.parse(HttpRequest.doGet("https://api.hh.ru/vacancies?text=" + params).toString());

        return model;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getSubmit(@Valid @ModelAttribute("form") Form form, BindingResult result, Model model) {
        String text = "Повар";
        String experience = "";
        if (form != null) {
            text = (form.getSearch() != null) ? form.getSearch() : "Повар";
            experience = form.getExperience();
        }
        String area = null;
        String salaryFrom = "";
        Integer perPage = 100;
        ru.unic.hr.model.Model vacancyInfo = getVacancies(text, area, salaryFrom, perPage, 0, experience);
        Integer vacanciesFound = vacancyInfo.getFound();
        perPage = vacancyInfo.getPerPage();
        Integer pages = vacancyInfo.getPages();
        List<Item> items = new ArrayList<>();

        List<Integer> range = IntStream.rangeClosed(0, pages).boxed().collect(Collectors.toList());

        Integer finalPerPage = perPage;
        String finalText = text;
        String finalExperience = experience;
        range.parallelStream().forEach(i -> {
                    items.addAll(getVacancies(finalText, area, salaryFrom, finalPerPage, i, finalExperience).getItems());
                }
        );

        List<Integer> analysisData = DataAnalysis.takeDataForAnalysis(items);

        Integer avgSalary = DataAnalysis.analysisAvgSalary(analysisData);

        List<Item> itemsFinal = new ArrayList<>();
        itemsFinal = items.parallelStream()
                .filter(sal -> sal.getSalary() != null && sal.getSalary().getFrom() != null)
                .collect(Collectors.toList());


        itemsFinal.sort(Item.compareBySalary.reversed());

        List<Experience> experiences = getExperiences();


        model.addAttribute("experiences", experiences);
        model.addAttribute("maxSalary", (itemsFinal.get(0) != null && itemsFinal.get(0).getSalary() != null) ? itemsFinal.get(0).getSalary().getFrom() : "");
        model.addAttribute("requestName", text);
        model.addAttribute("avgSalary", avgSalary);
        model.addAttribute("vacancies", vacanciesFound);
        model.addAttribute("items", itemsFinal.subList(0, 20));
        model.addAttribute("form", form);

        return "db";
    }

}
