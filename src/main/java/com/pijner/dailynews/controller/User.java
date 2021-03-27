/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pijner.dailynews.controller;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Prahar
 */
@Named()
@RequestScoped()
public class User {

    private ArrayList<NewsArticle> response;

    public User() {
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
    private void initValues() {
        this.updateResponse();
    }

    public void updateResponse() {
        NewsAPIHandler n = new NewsAPIHandler();
        n.getTopHeadlines();
        response = n.getArticleList();
    }

}
