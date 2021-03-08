package com.example.kingdle.response;

import com.google.gson.annotations.SerializedName;

public class BookeTitle {
    @SerializedName("bookname")
    String name;
    @SerializedName("ccontent")
    String content;

    public BookeTitle(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
