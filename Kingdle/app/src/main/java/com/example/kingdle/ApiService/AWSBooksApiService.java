package com.example.kingdle.ApiService;

import com.example.kingdle.TimeModel;
import com.example.kingdle.response.BookeTitle;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.*;


public interface AWSBooksApiService {
    @GET("data/content")
    Call<List<BookeTitle>> getBook();

    //POST method for Time Service
    //Yukan Zhang
    @POST
    Call<TimeModel> postTime(@Url String url);
}
