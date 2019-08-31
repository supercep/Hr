package ru.unic.hr.model.dictionary.area;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;
import ru.unic.hr.service.loader.AreasLoader;
import ru.unic.hr.service.parser.AreasParser;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by BritikovMI on 30.08.2019.
 */
public class Area {

    /**
     * id : 113
     * parent_id : null
     * name : Россия
     * areas : [{}]
     */

    private String id;
    private Object parent_id;
    private String name;
    private List<Area> areas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getParent_id() {
        return parent_id;
    }

    public void setParent_id(Object parent_id) {
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

    public static List<Area> getModel() {
        String content = AreasLoader.areasLoad();

        AreasParser parser = new AreasParser();
        List<Area> areasModel = Arrays.asList(parser.parse(content));

        return areasModel;
    }

    public static List<Area> areaGetter(List<Area> areasList) {
        List<Area> finalAreasList = new ArrayList<>();
        if (!areasList.isEmpty()) {
            areasList.forEach(area -> {
                finalAreasList.add(area);
                List<Area> subAreas = area.getAreas();
                finalAreasList.addAll(subAreas);
                subAreas.forEach(subAreasChilds -> {
                    finalAreasList.addAll(subAreasChilds.getAreas());
                });
            });
        }
        return finalAreasList;
    }
}
