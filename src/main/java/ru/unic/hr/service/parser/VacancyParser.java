package ru.unic.hr.service.parser;

import ru.unic.hr.model.Vacancy;

public class VacancyParser extends AbstractParser<Vacancy> {

    public Vacancy parse(String content) {
        return getGson().fromJson(content, Vacancy.class);
    }

}
