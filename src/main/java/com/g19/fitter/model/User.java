package com.g19.fitter.model;

import org.springframework.data.annotation.Id;

/**
 * Created by davidsudia on 4/22/16.
 */
public class User {

    @Id
    private String id;
    private String username;
    private String email;
    private String twitterToken;
    private String appName;
    private String apiKey;

    public User(String id, String username, String email, String twitterToken, String appName, String apiKey) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.twitterToken = twitterToken;
        this.appName = appName;
        this.apiKey = apiKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitterToken() {
        return twitterToken;
    }

    public void setTwitterToken(String twitterToken) {
        this.twitterToken = twitterToken;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
