/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pijner.dailynews.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author Prahar
 */
@SessionScoped
@Named()
public class Weather implements Serializable {

    private String temperature;
    private String feelsLike;
    private String condition;
    private String wind;
    private String uv;
    private String location;
    private String conditionImage;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getConditionImage() {
        return conditionImage;
    }

    public void setConditionImage(String conditionImage) {
        this.conditionImage = conditionImage;
    }

    public void fetchWeather() {
        String API_KEY = "36874bf3101f4d97ab8202009212703";
        String BASE_URL = "http://api.weatherapi.com/v1/current.json?";

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "key=" + API_KEY + "&q=" + this.location + "&aqi=no").newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        try {
            Response res = call.execute();
            String jsonString = res.body().string();
            System.out.println(jsonString);

            JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
            JsonObject currentWeather = jsonObject.getAsJsonObject("current");

            this.temperature = currentWeather.get("temp_c").getAsString();
            this.feelsLike = currentWeather.get("feelslike_c").getAsString();
            this.condition = currentWeather.getAsJsonObject("condition").get("text").getAsString();
            this.conditionImage = currentWeather.getAsJsonObject("condition").get("icon").getAsString();
            this.conditionImage = "http:" + this.conditionImage;
            this.wind = currentWeather.get("wind_kph").getAsString();
            this.uv = currentWeather.get("uv").getAsString();

        } catch (IOException | NullPointerException ex) {
            Logger.getLogger(NewsAPIHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
