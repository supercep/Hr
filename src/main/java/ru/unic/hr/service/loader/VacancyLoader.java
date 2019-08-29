package ru.unic.hr.service.loader;

import ru.unic.hr.model.Item;
import ru.unic.hr.service.builder.URLBuilder;
import ru.unic.hr.service.parser.VacancyParser;
import ru.unic.hr.utils.HttpRequest;

import java.util.List;

/**
 * Created by BritikovMI on 22.08.2019.
 */
public class VacancyLoader {
    public static String load(String text, String area, String salaryFrom, Integer perPage, Integer page, String experience, String currency, String search_label) {
        URLBuilder builder = new URLBuilder();
        String url = builder.urlBuilder(text, area, salaryFrom, perPage, page, experience, currency, search_label);

        System.out.println("URL= " + url);
        return HttpRequest.doGet(url).toString();
    }
}
