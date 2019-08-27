package ru.unic.hr.model.dictionary;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by BritikovMI on 27.08.2019.
 */
public enum SearchLabel {
    ONLY_WITH_PHOTO("only_with_photo", "Только с фотографией"),
    ONLY_WITH_SALARY("only_with_salary", "Не показывать резюме без зарплаты"),
    ONLY_WITH_AGE("only_with_age", "Не показывать резюме без указания возраста");

    private String id;
    private String name;

    SearchLabel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<SearchLabel> getSearchLabelProperties() {
        List<SearchLabel> searchLabels = new LinkedList<>();

        searchLabels.add(SearchLabel.ONLY_WITH_SALARY);

        searchLabels.add(SearchLabel.ONLY_WITH_PHOTO);

        searchLabels.add(SearchLabel.ONLY_WITH_AGE);

        return searchLabels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
