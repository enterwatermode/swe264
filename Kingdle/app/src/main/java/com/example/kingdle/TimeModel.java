package com.example.kingdle;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeModel {
    @SerializedName("time")
    @Expose
    private String time;
    public void setTime(String time){
        this.time = time;
    }
    public String getTime() {
        return time;
    }
}
