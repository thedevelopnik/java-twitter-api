package com.g19.fitter.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by davidsudia on 4/15/16.
 */

public class Tweet {
    private Tweet quotedTweet;
    private Media media;
    private java.util.Date createdAt;
    private String inReplyToScreenName;
    private String text;
    private ArrayList<String> urls;
    private ArrayList<String> hashtags;
    private ArrayList<String> userMentions;
    private String userScreenName;
    private String userProfileImageUrlHttps;
    private String userName;
    private Place place;

    public Tweet(Tweet quotedTweet, Media media, Date createdAt, String inReplyToScreenName, String text, ArrayList<String> urls, ArrayList<String> hashtags, ArrayList<String> userMentions, String userScreenName, String userProfileImageUrlHttps, String userName, Place place) {
        this.quotedTweet = quotedTweet;
        this.media = media;
        this.createdAt = createdAt;
        this.inReplyToScreenName = inReplyToScreenName;
        this.text = text;
        this.urls = urls;
        this.hashtags = hashtags;
        this.userMentions = userMentions;
        this.userScreenName = userScreenName;
        this.userProfileImageUrlHttps = userProfileImageUrlHttps;
        this.userName = userName;
        this.place = place;
    }

    public Tweet getQuotedTweet() {
        return quotedTweet;
    }

    public void setQuotedTweet(Tweet quotedTweet) {
        this.quotedTweet = quotedTweet;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<String> urls) {
        this.urls = urls;
    }

    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(ArrayList<String> hashtags) {
        this.hashtags = hashtags;
    }

    public ArrayList<String> getUserMentions() {
        return userMentions;
    }

    public void setUserMentions(ArrayList<String> userMentions) {
        this.userMentions = userMentions;
    }

    public String getUserScreenName() {
        return userScreenName;
    }

    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    public String getUserProfileImageUrlHttps() {
        return userProfileImageUrlHttps;
    }

    public void setUserProfileImageUrlHttps(String userProfileImageUrlHttps) {
        this.userProfileImageUrlHttps = userProfileImageUrlHttps;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
