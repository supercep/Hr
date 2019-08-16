package ru.unic.hr.service.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;

public abstract class AbstractParser<T> implements IParser<T> {
    private static Gson gson;

    public AbstractParser() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer())
                /*.registerTypeAdapter(Salary.class, new SalaryDeserializer())
                .registerTypeAdapter(MetroCityDictionary.class, new MetroDeserializer())
                .registerTypeAdapter(AreaDictionary.class, new AreaDeserializer())
                .registerTypeAdapter(ProfFieldDictionary.class, new ProfFieldDeserializer())*/;
        gson = builder.create();
    }

    public static Gson getGson() {
        return gson;
    }

    public static void setGson(Gson gson) {
        AbstractParser.gson = gson;
    }
}
