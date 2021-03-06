package ru.unic.hr.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.unic.hr.model.Item;
import ru.unic.hr.model.dictionary.Currency;
import ru.unic.hr.model.dictionary.Experience;
import ru.unic.hr.model.dictionary.SearchLabel;
import ru.unic.hr.model.dictionary.area.Area;
import ru.unic.hr.model.form.BasicForm;
import ru.unic.hr.model.form.Form;
import ru.unic.hr.service.DataAnalysis;
import ru.unic.hr.service.parser.VacancyParser;
import ru.unic.hr.utils.HttpRequest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.unic.hr.model.dictionary.Currency.getCurrenciesProperties;
import static ru.unic.hr.model.dictionary.Experience.getExperiencesProperties;
import static ru.unic.hr.model.dictionary.SearchLabel.getSearchLabelProperties;

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
        /*START BasicForm initialization*/
        BasicForm bf = BasicForm.basicFormInitilizer();
        String text = "";
        String experience = "";
        String currency = "";
        String searchLabel = "";
        String area = "";
        System.out.println(form.getSearch() + " " + form.getExperience() + " " + form.getCurrency() + " " + form.getResume_search_label());
        if (form != null) {

            text = (form.getSearch() != null) ? form.getSearch().replace(" ", "+") : bf.getText();

            experience = form.getExperience();
            experience = (experience != null) ? experience : "";
            System.out.println("EXP: " + experience);
            currency = (form.getCurrency() != null) ? form.getCurrency() : bf.getCurrency();
            searchLabel = (form.getResume_search_label() != null) ? form.getResume_search_label() : bf.getSearchLabel();
            area = (form.getArea() != null) ? form.getArea() : bf.getArea();
        }
        String salaryFrom = bf.getSalaryFrom();
        Integer perPage = bf.getPerPage();
        Integer vacanciesFound;
        Integer pages;
        List<Item> items = new ArrayList<>();
        /*END BasicForm initialization*/

        Map<ru.unic.hr.model.Model, Boolean> vacancyInfoMap = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, searchLabel); // Получаем базовую информацию по запросу

        Map.Entry<ru.unic.hr.model.Model, Boolean> entry = vacancyInfoMap.entrySet().iterator().next();
        ru.unic.hr.model.Model vacancyInfo = entry.getKey();
        Boolean isContainsVacancy = entry.getValue();

        System.out.println("REstService");
        if (isContainsVacancy) { //Если по запросу пришли вакансии, то получаем
            System.out.println("МЫ тут");
            vacanciesFound = vacancyInfo.getFound();
            perPage = vacancyInfo.getPerPage();
            pages = vacancyInfo.getPages();
            items = Item.getItems(text, area, salaryFrom, experience, pages, perPage, currency, searchLabel);
        } else { //Если не пришли, то пока просто возвращаем базовое заполнение
            text = bf.getText();
            area = bf.getArea();
            salaryFrom = bf.getSalaryFrom();
            experience = bf.getExperience();
            currency = bf.getCurrency();
            searchLabel = bf.getSearchLabel();
            vacancyInfo = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, searchLabel).entrySet().iterator().next().getKey(); // Получаем базовую информацию по запросу
            perPage = vacancyInfo.getPerPage();
            pages = vacancyInfo.getPages();
            vacanciesFound = vacancyInfo.getFound();
            items = Item.getItems(text, area, salaryFrom, experience, pages, perPage, currency, searchLabel);
        }

        List<Integer> analysisData = DataAnalysis.takeDataForAnalysis(items);

        Integer avgSalary = DataAnalysis.analysisAvgSalary(analysisData);

        List<Item> itemsFinal = items.parallelStream()
                .filter(sal -> sal.getSalary() != null && sal.getSalary().getFrom() != null)
                .sorted(Item.compareBySalary.reversed())
                .collect(Collectors.toList());


        List<Experience> experiencesProperties = getExperiencesProperties();
        List<Currency> currenciesProperties = getCurrenciesProperties();
        List<SearchLabel> searchLabelProperties = getSearchLabelProperties();
        model.addAttribute("experiences", experiencesProperties);
        model.addAttribute("areas", Area.areaGetter(Area.getModel()));
        model.addAttribute("currencies", currenciesProperties);
        model.addAttribute("resume_search_labeles", searchLabelProperties);
        model.addAttribute("maxSalary", (!itemsFinal.isEmpty() && itemsFinal.get(0) != null && itemsFinal.get(0).getSalary() != null) ? itemsFinal.get(0).getSalary().getFrom() : "");
        model.addAttribute("requestName", text.replace("+", " "));
        model.addAttribute("avgSalary", avgSalary);
        model.addAttribute("vacancies", vacanciesFound);
        model.addAttribute("items", (itemsFinal.size() > 20) ? itemsFinal.subList(0, 20) : itemsFinal);
        model.addAttribute("form", form);

        return "db";
    }

}
