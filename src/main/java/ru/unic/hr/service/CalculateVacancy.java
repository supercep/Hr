package ru.unic.hr.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.unic.hr.model.dictionary.Currency;
import ru.unic.hr.model.dictionary.Experience;
import ru.unic.hr.model.Item;
import ru.unic.hr.model.dictionary.SearchLabel;
import ru.unic.hr.model.form.BasicForm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ru.unic.hr.model.dictionary.Currency.getCurrenciesProperties;
import static ru.unic.hr.model.dictionary.Experience.getExperiencesProperties;
import static ru.unic.hr.model.dictionary.SearchLabel.getSearchLabelProperties;

/**
 * Created by BritikovMI on 21.08.2019.
 */
@Controller
public class CalculateVacancy {

    @RequestMapping("/")
    public String vacancyController(Model model) {
        /*START BasicForm initialization*/
        BasicForm bf = BasicForm.basicFormInitilizer();
        String text = bf.getText();
        String area = bf.getArea();
        String salaryFrom = bf.getSalaryFrom();
        Integer perPage = bf.getPerPage();
        String experience = bf.getExperience();
        String currency = bf.getCurrency();
        String searchLabel = bf.getSearchLabel();
        /*END BasicForm initialization*/

        ru.unic.hr.model.Model vacancyInfo = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, searchLabel); // Получаем базовую информацию по запросу

        Integer vacanciesFound = vacancyInfo.getFound();
        perPage = vacancyInfo.getPerPage();
        Integer pages = vacancyInfo.getPages();


        List<Item> items = new ArrayList<>();

        if(vacanciesFound != 0) { //Если по запросу пришли вакансии, то получаем
            items = Item.getItems(text, area, salaryFrom, experience, pages, perPage, currency, searchLabel);
        } else{ //Если не пришли, то пока просто возвращаем базовое заполнение
            text = bf.getText();
            area = bf.getArea();
            salaryFrom = bf.getSalaryFrom();
            experience = bf.getExperience();
            currency = bf.getCurrency();
            searchLabel = bf.getSearchLabel();
            vacancyInfo = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, searchLabel); // Получаем базовую информацию по запросу
            perPage = vacancyInfo.getPerPage();
            pages = vacancyInfo.getPages();
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
        model.addAttribute("currencies", currenciesProperties);
        model.addAttribute("resume_search_labeles", searchLabelProperties);
        model.addAttribute("maxSalary", (itemsFinal.get(0) != null && itemsFinal.get(0).getSalary() != null) ? itemsFinal.get(0).getSalary().getFrom() : "");
        model.addAttribute("requestName", text);
        model.addAttribute("avgSalary", avgSalary);
        model.addAttribute("vacancies", vacanciesFound);
        model.addAttribute("items", itemsFinal.subList(0, 20));
        return "db";
    }

}
