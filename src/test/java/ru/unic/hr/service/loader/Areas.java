package ru.unic.hr.service.loader;

import org.junit.Test;
import ru.unic.hr.model.dictionary.area.Area;

import java.util.List;

public class Areas {
    @Test
    public void getAllAreaas() {
        Area.getModel().stream()
                .filter(area -> area.getId().equals("113"))
                .forEach(area -> {
                    area.getAreas()
                    .forEach(areas-> {
                        areas.getAreas().forEach(area1 -> System.out.println(area1.getName()));
                    });
                });
    }
}
