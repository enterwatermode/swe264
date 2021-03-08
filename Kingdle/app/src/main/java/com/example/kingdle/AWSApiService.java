package com.example.kingdle;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.Body;
import retrofit2.http.Url;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface AWSApiService {
    @POST
    Call<TimeModel> postTime(@Url String url);
}
