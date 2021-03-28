package com.pijner.dailynews.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.*;
import java.util.Arrays;

/**
 * Class to handle API connection, data retrieval, and formatting for News 
 * articles.
 * 
 * @author Prahar
 */
public class NewsAPIHandler {

    private final String API_KEY;
    private final String BASE_URL;
    private ArrayList<NewsArticle> articleList;

    public NewsAPIHandler() {
        API_KEY = "5391234f9f9247949beb5e393bf20605";
        BASE_URL = "https://newsapi.org/v2/";

        articleList = new ArrayList<>();

    }

    public ArrayList<NewsArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(ArrayList<NewsArticle> articleList) {
        this.articleList = articleList;
    }

    public void getTopHeadlines() {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "top-headlines?country=CA&apiKey=" + API_KEY).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        try {
            Response res = call.execute();
            String jsonString = res.body().string();

            JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
            JsonArray articles = jsonObject.getAsJsonArray("articles");

            Gson gson = new Gson();
            this.articleList = new ArrayList<>(Arrays.asList(gson.fromJson(articles, NewsArticle[].class)));

        } catch (IOException | NullPointerException ex) {
            Logger.getLogger(NewsAPIHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
