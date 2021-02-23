package com.example.kingdle.responseClass;
import com.google.gson.annotations.SerializedName;

import java.util.*;

public class BookItem {
    @SerializedName("volumeInfo")
    Volumeinfo volumeinfo;

    public BookItem(Volumeinfo volumeinfo) {
        this.volumeinfo = volumeinfo;
    }

    public Volumeinfo getVolumeinfo() {
        return volumeinfo;
    }
}
class Volumeinfo{
    @SerializedName("title")
    String title;
    @SerializedName("subtitle")
    String subtitle;
    @SerializedName("authors")
    List<String> authors;
    @SerializedName("industryIdentifiers")
    List<IndustryInfo> induinfo;
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
}

class IndustryInfo{
    @SerializedName("type")
    String type;
    @SerializedName("identifier")
    String identifier;

    public IndustryInfo(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }
}
class Image{
    @SerializedName("thumbnail")
    String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
