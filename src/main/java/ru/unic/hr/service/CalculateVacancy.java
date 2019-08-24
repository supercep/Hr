package ru.unic.hr.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.unic.hr.model.Item;
import ru.unic.hr.service.loader.VacancyLoader;
import ru.unic.hr.service.parser.VacancyParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by BritikovMI on 21.08.2019.
 */
@Controller
public class CalculateVacancy {

    @RequestMapping("/")
    public String vacancyController(Model model) {
        String text = "java";
        String area = null;
        String salaryFrom = "";
        Integer perPage = 100;
        String experience = null;
        ru.unic.hr.model.Model vacancyInfo = getVacancies(text, area, salaryFrom, perPage, 0, experience);
        perPage = vacancyInfo.getPerPage();
        Integer pages = vacancyInfo.getPages();
        List<Item> items = new ArrayList<>();

        List<Integer> range = IntStream.rangeClosed(0, pages).boxed().collect(Collectors.toList());

        Integer finalPerPage = perPage;
        range.parallelStream().forEach(i -> {
                    items.addAll(getVacancies(text, area, salaryFrom, finalPerPage, i, experience).getItems());
                }
        );

        List<Integer> analysisData = DataAnalysis.takeDataForAnalysis(items);

        Integer avgSalary = DataAnalysis.analysisAvgSalary(analysisData);

        List<Item> itemsFinal = new ArrayList<>();
        itemsFinal = items.parallelStream()
                .filter(sal -> sal.getSalary() != null && sal.getSalary().getFrom() != null)
                        .collect(Collectors.toList());


        itemsFinal.sort(Item.compareBySalary.reversed());


        model.addAttribute("avgSalary", avgSalary);
        model.addAttribute("vacancies", items.size());
        model.addAttribute("items", itemsFinal.subList(0, 20));
        return "db";
    }

    public static ru.unic.hr.model.Model getVacancies(String text, String area, String salaryFrom, Integer perPage, Integer page, String experience) {
        String content = VacancyLoader.load(text, area, salaryFrom, perPage, page, experience);

        VacancyParser parser = new VacancyParser();
        ru.unic.hr.model.Model vacancyModel = null;

        if (content != null && !content.isEmpty()) {
            vacancyModel = parser.parse(content);
        }

        return vacancyModel;
    }
}
