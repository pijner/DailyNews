package com.pijner.dailynews.controller;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Class to store the list of news articles
 * 
 * @author Prahar
 */
@Named()
@RequestScoped()
public class News {

    private ArrayList<NewsArticle> response;

    public News() {
        NewsAPIHandler n = new NewsAPIHandler();
        response = n.getArticleList();
    }

    public ArrayList<NewsArticle> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<NewsArticle> response) {
        this.response = response;
    }

    @PostConstruct
    public void updateResponse() {
        NewsAPIHandler n = new NewsAPIHandler();
        n.getTopHeadlines();
        response = n.getArticleList();
    }

}
