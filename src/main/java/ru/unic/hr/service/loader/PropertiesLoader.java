package ru.unic.hr.service.loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by BritikovMI on 22.08.2019.
 */
public class PropertiesLoader {
    private Properties instance;
    public PropertiesLoader() {
        if(instance == null) {
            try (InputStream input = new FileInputStream("src/main/properties/hh.properties")) {

                instance = new Properties();

                instance.load(input);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getHhUrl() {
        return instance.getProperty("hh.url");
    }

    public String getHhVacancy() {
        return instance.getProperty("hh.vacancy");
    }

    public String getHhPropertyText() {
        return instance.getProperty("hh.property.text");
    }
    public String getHhPropertyAreas() {
        return instance.getProperty("hh.property.areas");
    }
}
