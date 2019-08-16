package ru.unic.hr.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = "items")
public class VacancyPage {
    private List<Vacancy> items;
    private Integer found;
    private Integer pages;
    private Integer perPage;
    private Integer page;
    private String clusters;
    private String arguments;
    private String alternate_url;

}
