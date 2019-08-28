package ru.unic.hr.service.builder;

import org.springframework.web.util.UriBuilder;
import ru.unic.hr.service.loader.PropertiesLoader;

/**
 * Created by BritikovMI on 22.08.2019.
 */
public class URLBuilder {
    static PropertiesLoader properties = new PropertiesLoader();

    public String urlBuilder(String text, String area,
                             String salaryFrom, Integer perPagePrimary,
                             Integer pagePrimary, String experience,
                             String currency, String search_label) {
        StringBuilder params = new StringBuilder();
        String concatParam;
        String attribute;
        String perPage = perPagePrimary.toString();
        String page = pagePrimary.toString();

        if (text != null && !text.isEmpty()) {
            concatParam = "text";
            attribute = text;
            params = urlConcat(concatParam, params, attribute);

        }

        if (area != null && !area.isEmpty()) {
            concatParam = "area";
            attribute = area;
            params = urlConcat(concatParam, params, attribute);

        }

        if (salaryFrom != null && !salaryFrom.isEmpty()) {
            concatParam = "salary";
            attribute = salaryFrom;
            params = urlConcat(concatParam, params, attribute);
        }

        if (perPage != null && !perPage.isEmpty()) {
            concatParam = "per_page";
            attribute = perPage;
            params = urlConcat(concatParam, params, attribute);
        }

        if (page != null && !page.isEmpty()) {
            concatParam = "page";
            attribute = page;
            params = urlConcat(concatParam, params, attribute);
        }

        if (experience != null && !experience.isEmpty()) {
            concatParam = "experience";
            attribute = experience;
            params = urlConcat(concatParam, params, attribute);
        }

        if (currency != null && !currency.isEmpty()) {
            concatParam = "currency";
            attribute = currency;
            params = urlConcat(concatParam, params, attribute);
        }

        if (search_label != null && !search_label.isEmpty()) {
            concatParam = "resume_search_label";
            attribute = search_label;
            params = urlConcat(concatParam, params, attribute);
        }


        String buildedUrl = properties.getHhUrl()
                + properties.getHhVacancy()
                + ((!params.toString().isEmpty() && params != null) ? "?" + params : "");

        return buildedUrl;
    }

    private StringBuilder urlConcat(String concatParam, StringBuilder params, String attribute) {
        if (params != null && !params.toString().isEmpty()) {
            params.append("&" + concatParam + "=" + attribute);
        } else {
            params.append(concatParam + "=" + attribute);
        }
        return params;
    }

}
