package ru.unic.hr.model.form;


import java.util.List;

/**
 * Created by BritikovMI on 26.08.2019.
 */
public class Form {
    private String search;
    //private Experience experience;
    private String experience;
    private String currency;
    private String resume_search_label;
    private String area;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getResume_search_label() {
        return resume_search_label;
    }

    public void setResume_search_label(String resume_search_label) {
        this.resume_search_label = resume_search_label;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Form(String search, String experience, String currency, String resume_search_label, String area) {
        this.search = search;
        this.experience = experience;
        this.currency = currency;
        this.resume_search_label = resume_search_label;
        this.area = area;
    }
}
