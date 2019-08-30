package ru.unic.hr.model.dictionary;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by BritikovMI on 29.08.2019.
 */
public class Area {
    private String parent_id;

    private String name;

    private List<Area> areas;

    private String id;

    public Area(String parent_id, String name, List<Area> areas, String id) {
        this.parent_id = parent_id;
        this.name = name;
        this.areas = areas;
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return (name + "(\"" + id + "\",\"" + parent_id + "\",\"" + name + "\"," + areas + ")");
    }

}
