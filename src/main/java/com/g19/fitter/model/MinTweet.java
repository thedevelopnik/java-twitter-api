package com.g19.fitter.model;

/*
 * Created by davidsudia on 4/26/16.
 */
public class MinTweet {
    private String id;
    private String text;
    private String user;
    private String profileImageUrl;
    private String mediaType;
    private String mediaUrl;
    private float grade;

    public MinTweet(String id, String text, String user, String profileImageUrl, String mediaType, String mediaUrl, float grade) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.profileImageUrl = profileImageUrl;
        this.mediaType = mediaType;
        this.mediaUrl = mediaUrl;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getText() {
        return text;

    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
