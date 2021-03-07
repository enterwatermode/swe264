package com.example.kingdle.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Volumeinfo{
    @SerializedName("title")
    String title;
    @SerializedName("subtitle")
    String subtitle;
    @SerializedName("authors")
    List<String> authors;
    @SerializedName("industryIdentifiers")
    List<IndustryInfo> induinfo;
    @SerializedName("description")
    String description;
    @SerializedName("averageRating")
    Float rating;
    @SerializedName("imageLinks")
    private Image imageLinks;

    public Volumeinfo(String title, String subtitle, List<String> authors, List<IndustryInfo> induinfo, Image imageLinks) {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.induinfo = induinfo;
        this.imageLinks = imageLinks;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<IndustryInfo> getInduinfo() {
        return induinfo;
    }

    public Image getImageLinks() {
        return imageLinks;
    }

    public String getDescription() {
        return description;
    }

    public Float getRating(){
        return rating;
    }
}