package ru.unic.hr.model.dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import ru.unic.hr.model.Model;
import ru.unic.hr.service.loader.AreasLoader;
import ru.unic.hr.service.loader.VacancyLoader;
import ru.unic.hr.service.parser.AreasParser;
import ru.unic.hr.service.parser.VacancyParser;

public class Area {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("parent_id")
    @Expose
    private Object parentId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("areas")
    @Expose
    private List<ChildAreas> areas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Area() {
    }

    /**
     * 
     * @param id
     * @param parentId
     * @param name
     * @param areas
     */
    public Area(String id, Object parentId, String name, List<ChildAreas> areas) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.areas = areas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Area withId(String id) {
        this.id = id;
        return this;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public Area withParentId(Object parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area withName(String name) {
        this.name = name;
        return this;
    }

    public List<ChildAreas> getAreas() {
        return areas;
    }

    public void setAreas(List<ChildAreas> areas) {
        this.areas = areas;
    }

    public Area withAreas(List<ChildAreas> areas) {
        this.areas = areas;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("parentId", parentId).append("name", name).append("areas", areas).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(parentId).append(name).append(areas).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Area) == false) {
            return false;
        }
        Area rhs = ((Area) other);
        return new EqualsBuilder().append(id, rhs.id).append(parentId, rhs.parentId).append(name, rhs.name).append(areas, rhs.areas).isEquals();
    }

}
