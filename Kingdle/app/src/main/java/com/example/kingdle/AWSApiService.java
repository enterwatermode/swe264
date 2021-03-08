package com.example.kingdle;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface AWSApiService {
    @POST("/{time}")
    @FormUrlEncoded
    Call<TimeModel> postTime(@Field("time") String title);
}
