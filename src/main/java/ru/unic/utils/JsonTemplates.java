package ru.unic.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

/**
 * Created by BritikovMI on 01.04.2019.
 */
@SpringBootApplication(exclude = {GsonAutoConfiguration.class})
public class JsonTemplates {

    public static JsonObject jiraProjectCreationData(String key, String name, String projectTypeKey, String userName){
        JsonObject projectCreationData = new JsonObject();
        projectCreationData.addProperty("key", key); //ProjectKey
        projectCreationData.addProperty("name", name); //Project name
        projectCreationData.addProperty("projectTypeKey", projectTypeKey); //e.g. -- "software" or "business"
        projectCreationData.addProperty("description", "Example Project description");
//        projectCreationData.addProperty("url", projectUrl);
        projectCreationData.addProperty("assigneeType", "PROJECT_LEAD");
        projectCreationData.addProperty("lead", userName);

        return projectCreationData;
    }

    public static String pojoToJson(Object value){
        Gson json = new Gson();
        return json.toJson(value);
    }

}



