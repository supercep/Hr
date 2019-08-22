package ru.unic.hr.service.builder;

import ru.unic.hr.service.loader.PropertiesLoader;

/**
 * Created by BritikovMI on 22.08.2019.
 */
public class URLBuilder {
    //TODO BUILDER with
    static PropertiesLoader properties = new PropertiesLoader();
    public static String urlBuilder() {
        StringBuilder sb = new StringBuilder();

        return null;
    }

    public static String withText(){
        return properties.getHhPropertyText() + "=";
    }

}
