package ru.unic.hr.utils;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import org.json.JSONObject;

/**
 * Created by BritikovMI on 15.08.2019.
 */
public class HttpRequest {

    public static JSONObject doPost(String uri, String autorizationKey, String body){
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.post(uri)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", autorizationKey)
                    .body(body)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody().getObject();
    }

    public static JsonNode doGet(String uri, Boolean node){
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(uri)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }

    public static JSONObject doGet(String uri){
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get(uri)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("User-Agent", "")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody().getObject();
    }

}
