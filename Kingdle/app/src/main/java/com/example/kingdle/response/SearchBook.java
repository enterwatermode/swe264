package com.example.kingdle.response;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class SearchBook {
    @SerializedName("items")
    List<BookItem> items;

    public SearchBook(List<BookItem> items) {
        this.items = items;
    }

    public List<BookItem> getItems() {
        return items;
    }
}
