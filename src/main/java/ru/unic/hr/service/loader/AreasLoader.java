package ru.unic.hr.service.loader;

import ru.unic.hr.utils.HttpRequest;

/**
 * Created by BritikovMI on 30.08.2019.
 */
public class AreasLoader {
    static PropertiesLoader properties = new PropertiesLoader();

    public static String areasLoad() {
        String url = properties.getHhUrl() + properties.getHhPropertyAreas();
        System.out.println(url);
        return HttpRequest.doGet(url, true).toString();
    }
}
