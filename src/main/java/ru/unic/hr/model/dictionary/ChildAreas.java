package ru.unic.hr.model.dictionary;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ChildAreas {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("areas")
    @Expose
    private List<Object> areas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ChildAreas() {
    }

    /**
     * 
     * @param id
     * @param parentId
     * @param name
     * @param areas
     */
    public ChildAreas(String id, String parentId, String name, List<Object> areas) {
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

    public ChildAreas withId(String id) {
        this.id = id;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public ChildAreas withParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildAreas withName(String name) {
        this.name = name;
        return this;
    }

    public List<Object> getAreas() {
        return areas;
    }

    public void setAreas(List<Object> areas) {
        this.areas = areas;
    }

    public ChildAreas withAreas(List<Object> areas) {
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
        if ((other instanceof ChildAreas) == false) {
            return false;
        }
        ChildAreas rhs = ((ChildAreas) other);
        return new EqualsBuilder().append(id, rhs.id).append(parentId, rhs.parentId).append(name, rhs.name).append(areas, rhs.areas).isEquals();
    }

}
