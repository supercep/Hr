package ru.unic.hr.service.loader;

import ru.unic.hr.model.Item;
import ru.unic.hr.service.parser.VacancyParser;
import ru.unic.hr.utils.HttpRequest;

import java.util.List;

/**
 * Created by BritikovMI on 22.08.2019.
 */
public class VacancyLoader {
    public static String load(String text) {
        return HttpRequest.doGet("https://api.hh.ru/vacancies?text=" + text).toString();
    }
}
