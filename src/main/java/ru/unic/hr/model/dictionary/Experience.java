package ru.unic.hr.model.dictionary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by BritikovMI on 27.08.2019.
 */
public enum Experience {
    WITHOUT("Без учета", ""),
    NOEXPERIENCE("Нет опыта", "noExperience"),
    BETWEEN1AND3("От 1 года до 3 лет", "between1And3"),
    BETWEEN3AND6("От 3 до 6 лет", "between3And6"),
    MORETHAN6("Более 6 лет", "moreThan6");

    private String value;
    private String key;

    Experience(String value, String key) {
        this.value = value;
        this.key = key;
    }

    public static List<Experience> getExperiencesProperties() {
        List<Experience> experiences = new LinkedList<>();

        experiences.add(Experience.WITHOUT);

        experiences.add(Experience.NOEXPERIENCE);

        experiences.add(Experience.BETWEEN1AND3);

        experiences.add(Experience.BETWEEN3AND6);

        experiences.add(Experience.MORETHAN6);


        return experiences;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }


}
