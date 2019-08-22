package ru.unic.hr.service.builder;

import org.springframework.web.util.UriBuilder;
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

    public String withText(){
        return this + properties.getHhPropertyText() + "=";
    }


    public static void main(String[] args) {
        URLBuilder ub = new URLBuilder();
        System.out.println(ub.withText());

    }
}
