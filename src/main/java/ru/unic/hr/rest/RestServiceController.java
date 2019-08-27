package ru.unic.hr.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.unic.hr.model.dictionary.Currency;
import ru.unic.hr.model.dictionary.Experience;
import ru.unic.hr.model.dictionary.SearchLabel;
import ru.unic.hr.model.form.BasicForm;
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

import static ru.unic.hr.model.dictionary.Currency.getCurrenciesProperties;
import static ru.unic.hr.model.dictionary.Experience.getExperiencesProperties;
import static ru.unic.hr.model.Model.getVacancies;
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
        String search_label = "";
        if (form != null) {
            text = (form.getSearch() != null) ? form.getSearch() : bf.getText();
            experience = form.getExperience();
            currency = (form.getCurrency() != null) ? form.getCurrency() : bf.getCurrency();
            search_label = (form.getResume_search_label() != null) ? form.getResume_search_label() : bf.getSearchLabel();
        }
        String area = bf.getArea();
        String salaryFrom = bf.getSalaryFrom();
        Integer perPage = bf.getPerPage();
        /*END BasicForm initialization*/

        ru.unic.hr.model.Model vacancyInfo = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, search_label); // Получаем базовую информацию по запросу

        Integer vacanciesFound = vacancyInfo.getFound();
        perPage = vacancyInfo.getPerPage();
        Integer pages = vacancyInfo.getPages();


        List<Item> items = new ArrayList<>();

        if(vacanciesFound!=null && vacanciesFound != 0) { //Если по запросу пришли вакансии, то получаем
            items = Item.getItems(text, area, salaryFrom, experience, pages, perPage, currency, search_label);
        } else{ //Если не пришли, то пока просто возвращаем базовое заполнение
            text = bf.getText();
            area = bf.getArea();
            salaryFrom = bf.getSalaryFrom();
            experience = bf.getExperience();
            currency = bf.getCurrency();
            search_label = bf.getSearchLabel();
            vacancyInfo = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, search_label); // Получаем базовую информацию по запросу
            perPage = vacancyInfo.getPerPage();
            pages = vacancyInfo.getPages();
            items = Item.getItems(text, area, salaryFrom, experience, pages, perPage, currency, search_label);
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
        model.addAttribute("currencies", currenciesProperties);
        model.addAttribute("resume_search_labeles", searchLabelProperties);
        model.addAttribute("maxSalary", (itemsFinal.get(0) != null && itemsFinal.get(0).getSalary() != null) ? itemsFinal.get(0).getSalary().getFrom() : "");
        model.addAttribute("requestName", text);
        model.addAttribute("avgSalary", avgSalary);
        model.addAttribute("vacancies", vacanciesFound);
        model.addAttribute("items", itemsFinal.subList(0, 20));
        model.addAttribute("form", form);

        return "db";
    }

}
