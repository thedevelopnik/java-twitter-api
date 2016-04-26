package com.g19.fitter.model;


import java.util.ArrayList;

/*
 * Created by davidsudia on 4/18/16.
 */
class Place {
    private String url;
    private String fullName;
    private String countryCode;
    private ArrayList<String> coordinates;
    private String type;

    public Place(String url, String fullName, String countryCode, ArrayList<String> coordinates, String type) {
        this.url = url;
        this.fullName = fullName;
        this.countryCode = countryCode;
        this.coordinates = coordinates;
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public ArrayList<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<String> coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
