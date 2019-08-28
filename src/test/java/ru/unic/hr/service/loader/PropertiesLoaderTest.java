package ru.unic.hr.service.loader;

import org.junit.Test;
import ru.unic.hr.model.Item;
import ru.unic.hr.model.dictionary.Currency;
import ru.unic.hr.model.dictionary.Experience;
import ru.unic.hr.model.dictionary.SearchLabel;
import ru.unic.hr.model.form.BasicForm;
import ru.unic.hr.service.DataAnalysis;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ru.unic.hr.model.Model.getVacancies;
import static ru.unic.hr.model.dictionary.Currency.getCurrenciesProperties;
import static ru.unic.hr.model.dictionary.Experience.getExperiencesProperties;
import static ru.unic.hr.model.dictionary.SearchLabel.getSearchLabelProperties;

/**
 * Created by BritikovMI on 22.08.2019.
 */
public class PropertiesLoaderTest {

    @Test
    public void test() {
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

        Map<ru.unic.hr.model.Model, Boolean> vacancyInfoMap = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, searchLabel); // Получаем базовую информацию по запросу

        Map.Entry<ru.unic.hr.model.Model, Boolean> entry = vacancyInfoMap.entrySet().iterator().next();
        ru.unic.hr.model.Model vacancyInfo = entry.getKey();
        Boolean isContainsVacancy = entry.getValue();

        Integer vacanciesFound = vacancyInfo.getFound();
        perPage = vacancyInfo.getPerPage();
        Integer pages = vacancyInfo.getPages();


        List<Item> items = new ArrayList<>();

        if (isContainsVacancy) {  //Если по запросу пришли вакансии, то получаем
            items = Item.getItems(text, area, salaryFrom, experience, pages, perPage, currency, searchLabel);
        } else{ //Если не пришли, то пока просто возвращаем базовое заполнение
            text = bf.getText();
            area = bf.getArea();
            salaryFrom = bf.getSalaryFrom();
            experience = bf.getExperience();
            currency = bf.getCurrency();
            searchLabel = bf.getSearchLabel();
            vacancyInfo = ru.unic.hr.model.Model.getVacancies(text, area, salaryFrom, perPage, 0, experience, currency, searchLabel).entrySet().iterator().next().getKey(); // Получаем базовую информацию по запросу
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

        itemsFinal.forEach(it-> System.out.println(it.getId()));

//        System.out.println(avgSalary);
//
//        System.out.println("Вакансий на страницу" + perPage);
//        System.out.println("Страниц" + pages);
    }



}