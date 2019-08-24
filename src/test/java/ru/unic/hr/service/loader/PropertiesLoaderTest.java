package ru.unic.hr.service.loader;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.unic.hr.model.Item;
import ru.unic.hr.service.DataAnalysis;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static ru.unic.hr.service.CalculateVacancy.getVacancies;

/**
 * Created by BritikovMI on 22.08.2019.
 */
public class PropertiesLoaderTest {

    @Test
    public void test() {
        String text = "java";
        String area = null;
        String salaryFrom = "";
        Integer perPage = 100;
        String experience = "between1And3";
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
        items.parallelStream()
                .forEach(sal -> {
                    if(sal.getSalary() != null && sal.getSalary().getFrom() != null)
                        itemsFinal.add(sal);
    });


        Collections.sort(itemsFinal, Item.compareBySalary.reversed());

        itemsFinal.subList(0, 20).forEach(temp-> System.out.println(temp.getName() +" " + temp.getSalary().getFrom() + " " + temp.getAlternateUrl()));

//        System.out.println(avgSalary);
//
//        System.out.println("Вакансий на страницу" + perPage);
//        System.out.println("Страниц" + pages);
    }



}