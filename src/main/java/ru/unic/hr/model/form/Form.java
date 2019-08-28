package ru.unic.hr.model.form;


import ru.unic.hr.model.dictionary.Currency;
import ru.unic.hr.model.dictionary.SearchLabel;

import java.util.List;

/**
 * Created by BritikovMI on 26.08.2019.
 */
public class Form {
    private String search;
    //private Experience experience;
    private Experience experience;
    private Currency currency;
    private SearchLabel resume_search_label;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public SearchLabel getResume_search_label() {
        return resume_search_label;
    }

    public void setResume_search_label(SearchLabel resume_search_label) {
        this.resume_search_label = resume_search_label;
    }
}
