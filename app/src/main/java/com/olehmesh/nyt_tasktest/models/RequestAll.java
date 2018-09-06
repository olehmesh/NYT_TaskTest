package com.olehmesh.nyt_tasktest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestAll {

    @SerializedName("results")
    private List<FieldsAPI> list;

    public RequestAll(List<FieldsAPI> list) {

        this.list = list;
    }

    public List<FieldsAPI> getList() {

        return list;
    }
}

