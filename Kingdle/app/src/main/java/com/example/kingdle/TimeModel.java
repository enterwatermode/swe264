package com.example.kingdle;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/***********************************
 Component: TimeModel
 Author: Yukan Zhang
 Functionality: get API reponse
 ***********************************/
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
