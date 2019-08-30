
package ru.unic.hr.model.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import ru.unic.hr.model.Item;
import ru.unic.hr.service.loader.AreasLoader;
import ru.unic.hr.service.loader.VacancyLoader;
import ru.unic.hr.service.parser.AreasParser;
import ru.unic.hr.service.parser.VacancyParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

    @SerializedName("areas")
    @Expose
    private List<Area> areas = new ArrayList<Area>();

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

}
