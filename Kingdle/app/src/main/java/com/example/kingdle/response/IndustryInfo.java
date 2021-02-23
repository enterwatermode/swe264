package com.example.kingdle.response;

import com.google.gson.annotations.SerializedName;

public class IndustryInfo{
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
