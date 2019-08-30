package ru.unic.hr.http;

import ru.unic.hr.model.dictionary.area.Area;

import java.util.List;
import java.util.Map;

/**
 * Created by BritikovMI on 29.08.2019.
 */
public class CreateAreas {
    public static void main(String[] args) {

        List<Area> areas = Area.getModel();

        areas.forEach(s-> {
            List<Area.AreasBeanX> subArea = s.getAreas();
            System.out.println(s.getId() + " " + s.getName());
            subArea.forEach(sub-> System.out.println("\t" + sub.getId() + " " + sub.getName()));
        });


    }
}
