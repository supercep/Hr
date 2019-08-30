package ru.unic.hr.service.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.unic.hr.model.dictionary.area.Area;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class AreasParser {

    private Gson instance() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer())
                /*.registerTypeAdapter(Salary.class, new SalaryDeserializer())
                .registerTypeAdapter(MetroCityDictionary.class, new MetroDeserializer())
                .registerTypeAdapter(AreaDictionary.class, new AreaDeserializer())
                .registerTypeAdapter(ProfFieldDictionary.class, new ProfFieldDeserializer())*/;
        return builder.create();
    }

    public Area[] parse(String content) {
        return instance().fromJson(content, Area[].class);
    }

}
