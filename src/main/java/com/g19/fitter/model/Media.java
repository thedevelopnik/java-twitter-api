package com.g19.fitter.model;

/*
 * Created by davidsudia on 4/18/16.
 */
class Media {
    private String type;
    private String mediaUrlHttps;
    private String url;

    public Media(String type, String mediaUrlHttps, String url) {
        this.type = type;
        this.mediaUrlHttps = mediaUrlHttps;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaUrlHttps() {
        return mediaUrlHttps;
    }

    public void setMediaUrlHttps(String mediaUrlHttps) {
        this.mediaUrlHttps = mediaUrlHttps;
    }
}
