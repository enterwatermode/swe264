package com.example.kingdle.response;

import com.google.gson.annotations.SerializedName;

public class Image{
    @SerializedName("thumbnail")
    String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}