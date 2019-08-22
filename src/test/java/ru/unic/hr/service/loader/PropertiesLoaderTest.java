package ru.unic.hr.service.loader;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by BritikovMI on 22.08.2019.
 */
public class PropertiesLoaderTest {
    @Test
    public void test(){
        PropertiesLoader properties = new PropertiesLoader();
        System.out.println(properties.getHhUrl());
    }

}