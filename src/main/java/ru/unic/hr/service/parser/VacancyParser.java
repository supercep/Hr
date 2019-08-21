package ru.unic.hr.service.parser;

import ru.unic.hr.model.Model;

public class VacancyParser extends AbstractParser<Model> {

    public Model parse(String content) {
        return getGson().fromJson(content, Model.class);
    }

}
