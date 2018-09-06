package com.olehmesh.nyt_tasktest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {

    @SerializedName("type")
    private String type;
    @SerializedName("media-metadata")
    private List<MediaMetaData> mediaMetaData = null;

    public String getType() {
        return type;
    }

    public List<MediaMetaData> getMediaMetaData() {
        return mediaMetaData;
    }


}
