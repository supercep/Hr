package ru.unic.hr.http;

import ru.unic.hr.model.dictionary.Area;

import java.util.ArrayList;

/**
 * Created by BritikovMI on 29.08.2019.
 */
public class CreateAreas {
    public static void main(String[] args) {
        Area area = new Area(null, "Россия", null, "1");

        System.out.println(area);
    }
}
