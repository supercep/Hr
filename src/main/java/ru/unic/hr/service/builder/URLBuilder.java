package ru.unic.hr.service.builder;

import ru.unic.hr.service.loader.PropertiesLoader;

/**
 * Created by BritikovMI on 22.08.2019.
 */
public class URLBuilder {
    static PropertiesLoader properties = new PropertiesLoader();

    public String urlBuilder(String text, String area, String salaryFrom) {
        StringBuilder params = new StringBuilder();
        String concatParam;
        String attribute;

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


        return properties.getHhUrl()
                + properties.getHhVacancy()
                + ((!params.toString().isEmpty() && params != null) ? "?" + params : "");
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
