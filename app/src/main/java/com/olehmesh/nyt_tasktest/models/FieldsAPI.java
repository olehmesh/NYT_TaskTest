package com.olehmesh.nyt_tasktest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FieldsAPI {

    private String title;
    @SerializedName("abstract")
    private String description;
    @SerializedName("published_date")
    private String date;
    @SerializedName("media")
    private List<Media> media = null;

    public FieldsAPI(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Media> getMedia() {
        return media;
    }
}
