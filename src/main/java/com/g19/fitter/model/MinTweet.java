package com.g19.fitter.model;

/*
 * Created by davidsudia on 4/26/16.
 */
public class MinTweet {
    private String text;
    private String user;
    private String profileImageUrl;
    private String mediaType;
    private String mediaUrl;

    public MinTweet(String text, String user, String profileImageUrl, String mediaType, String mediaUrl) {
        this.text = text;
        this.user = user;
        this.profileImageUrl = profileImageUrl;
        this.mediaType = mediaType;
        this.mediaUrl = mediaUrl;
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
}
