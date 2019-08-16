package ru.unic.hr.model.dictionary.entry;

public interface IDictionaryEntry extends INullable {
    public String getId();

    public void setId(String id);

    public String getName();

    public void setName(String name);
}
