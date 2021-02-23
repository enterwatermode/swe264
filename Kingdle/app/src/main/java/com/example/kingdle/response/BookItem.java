package com.example.kingdle.response;
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


